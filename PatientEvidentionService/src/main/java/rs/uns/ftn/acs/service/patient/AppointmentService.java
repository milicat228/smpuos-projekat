package rs.uns.ftn.acs.service.patient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import rs.uns.ftn.acs.dto.patient.AppointmentDTO;
import rs.uns.ftn.acs.dto.patient.AppointmentStatus;
import rs.uns.ftn.acs.entity.Patient;
import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.feignclient.AppoinmentClient;

@Service
public class AppointmentService {
	@Autowired
	private AppoinmentClient appoinmentClient;

	@HystrixCommand(fallbackMethod = "getAppointmentsFallback")
	public List<AppointmentDTO> getAppointments(Patient patient) throws ResourceNotFoundException {
		List<AppointmentDTO> ret = appoinmentClient.getAppointments().getBody();
		calculateAppointmentsStatus(patient, ret);
		return ret;
	}

	public List<AppointmentDTO> getAppointmentsFallback(Patient patient){
		System.err.println("Fallback method called for get appointments.");
		System.err.println("Generating fake appointments for patient.");
		ArrayList<AppointmentDTO> ret = new ArrayList<AppointmentDTO>();

		// pacijent sa isteklim osiguranjem
		if (patient.getLBO().equals("27700296463")) {
			AppointmentDTO temp = new AppointmentDTO(1, dateNHoursFromNow(2), 30, "Neki lekar", null);
			ret.add(temp);
		}

		// pacijentu vazi osiguranje ali je kasnio 3 puta
		if (patient.getLBO().equals("28700346910")) {
			ret.add(new AppointmentDTO(1, dateNHoursFromNow(-600), 30, "Neki lekar", false));
			ret.add(new AppointmentDTO(1, dateNHoursFromNow(-400), 30, "Neki lekar", false));
			ret.add(new AppointmentDTO(1, dateNHoursFromNow(-40), 30, "Neki lekar", false));
			ret.add(new AppointmentDTO(1, dateNHoursFromNow(2), 30, "Neki lekar", null));
		}

		// pacijentu vazi osiguranje i nije kasnio 3 puta
		if (patient.getLBO().equals("21600308163")) {
			ret.add(new AppointmentDTO(1, dateNHoursFromNow(-600), 30, "Neki lekar", true));
			ret.add(new AppointmentDTO(1, dateNHoursFromNow(-400), 30, "Neki lekar", true));
			ret.add(new AppointmentDTO(1, dateNHoursFromNow(-40), 30, "Neki lekar", true));
			ret.add(new AppointmentDTO(1, dateNHoursFromNow(2), 30, "Neki lekar", null));
		}

		calculateAppointmentsStatus(patient, ret);
		return ret;
	}

	@HystrixCommand(fallbackMethod = "confirmArrivalFallback")
	public Boolean confirmArrival(String lbo, Integer appointmentId) {
		appoinmentClient.confirmArrival();
		return true;
	}

	public Boolean confirmArrivalFallback(String lbo, Integer appointmentId) {
		System.err.println("Fallback method called for patient arrival confirmation.");
		return false;
	}

	private void calculateAppointmentsStatus(Patient patient, List<AppointmentDTO> appointments) {
		for (AppointmentDTO appointmentDTO : appointments) {
			appointmentDTO.setStatus(calculateAppointmentStatus(patient, appointmentDTO));
		}
	}

	/**
	 * Calculate status for appointment based on date and patient insurence end date.
	 * @param patient
	 * @param appointmentDTO
	 * @return
	 */
	private AppointmentStatus calculateAppointmentStatus(Patient patient, AppointmentDTO appointmentDTO) {
		Date now = new Date();

		// proveri da li je datum iz proslosti
		if (appointmentDTO.getDate().before(now)) {
			if (appointmentDTO.getPatientArrivedOnTime()) {
				return AppointmentStatus.IN_PAST;
			}
			return AppointmentStatus.PATIENT_WAS_LATE;
		}

		// proveri da li je zakazano danas (u ostatku dana)
		if (DateUtils.isSameDay(now, appointmentDTO.getDate())) {
			// proveri vazi li pacijentu osiguranje
			if (patient.isInsurenceValid()) {
				return AppointmentStatus.TODAY;
			}
			return AppointmentStatus.PATIENT_HAS_NO_INSURENCE;
		}

		return AppointmentStatus.IN_FUTURE;
	}

	private Date dateNHoursFromNow(Integer hours) {
		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date()); // sets calendar time/date
		cal.add(Calendar.HOUR_OF_DAY, hours); // adds one hour
		return cal.getTime();
	}
}
