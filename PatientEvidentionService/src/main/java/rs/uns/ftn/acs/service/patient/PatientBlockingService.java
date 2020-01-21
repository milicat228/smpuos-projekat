package rs.uns.ftn.acs.service.patient;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import rs.uns.ftn.acs.dto.patient.AppointmentDTO;
import rs.uns.ftn.acs.dto.patient.AppointmentStatus;
import rs.uns.ftn.acs.entity.Patient;
import rs.uns.ftn.acs.feignclient.PatientClient;

@Service
public class PatientBlockingService {
	private static final Integer MAX_LATE = 3;
	
	@Autowired
	private PatientClient patientClient;
	
	@HystrixCommand(fallbackMethod = "blockIfNeededFallback")
	public Boolean blockIfNeeded(Patient patient, List<AppointmentDTO> appointments) {
		Integer late = appointments.stream()
			    .filter(appointment -> appointment.getStatus().equals(AppointmentStatus.PATIENT_WAS_LATE))
			    .collect(Collectors.toList()).size();
		
		if(late >= MAX_LATE) {
			patientClient.blockPatient();
			return true;
		}
		return false;
	}
	
	
	public Boolean blockIfNeededFallback(Patient patient, List<AppointmentDTO> appointments) {
		Integer late = appointments.stream()
			    .filter(appointment -> appointment.getStatus().equals(AppointmentStatus.PATIENT_WAS_LATE))
			    .collect(Collectors.toList()).size();
		
		if(late >= MAX_LATE) {
			System.err.println("Patient should be blocked, but patient service unavailable. Using fallback.");
			return true;
		}
		return false;
	}
}
