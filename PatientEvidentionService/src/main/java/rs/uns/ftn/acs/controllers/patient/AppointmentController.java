package rs.uns.ftn.acs.controllers.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dto.patient.AppointmentDTO;
import rs.uns.ftn.acs.dto.patient.AppointmentsDTO;
import rs.uns.ftn.acs.entity.Patient;
import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.service.patient.AppointmentService;
import rs.uns.ftn.acs.service.patient.PatientBlockingService;
import rs.uns.ftn.acs.service.patient.PatientService;

@RestController
@RequestMapping("patient")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private PatientBlockingService patientBlockingService;

	@PreAuthorize("hasAnyRole('NURSE')")
	@RequestMapping(value = "/{lbo}/appointment", method = RequestMethod.GET)
	public ResponseEntity<AppointmentsDTO> getAll(@PathVariable String lbo) throws ResourceNotFoundException{
		Patient patient = patientService.updateInsurenceDate(lbo);
		List<AppointmentDTO> appointments = appointmentService.getAppointments(patient);
		Boolean blocked = patientBlockingService.blockIfNeeded(patient, appointments);
		AppointmentsDTO ret = new AppointmentsDTO(blocked, appointments);
		ret.setAppointments(appointments);
		return new ResponseEntity<AppointmentsDTO>(ret, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('NURSE')")
	@RequestMapping(value = "/{lbo}/appointment/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> confirmArrival(@PathVariable String lbo, @PathVariable Integer id) throws ResourceNotFoundException{
		Boolean ret = appointmentService.confirmArrival(lbo, id);
		return new ResponseEntity<Boolean>(ret, HttpStatus.OK);
	}
}
