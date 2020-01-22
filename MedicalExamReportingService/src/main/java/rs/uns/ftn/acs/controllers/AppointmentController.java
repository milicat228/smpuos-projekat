package rs.uns.ftn.acs.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dtos.AppointmentDTO;import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.feignclient.PatientClient;
import rs.uns.ftn.acs.model.Appointment;
import rs.uns.ftn.acs.model.Doctor;
import rs.uns.ftn.acs.model.Report;
import rs.uns.ftn.acs.model.UserAccount;
import rs.uns.ftn.acs.services.AppointmentService;
import rs.uns.ftn.acs.services.ProfileService;
import rs.uns.ftn.acs.services.ReportService;

@RestController
@RequestMapping(value="/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private PatientClient patientClient;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void addAppointment(@RequestBody Appointment a) throws ResourceNotFoundException {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
		String username=auth.getName();
		UserAccount account=profileService.findByUsername(username);
		a.setDoctor((Doctor)account);
		appointmentService.saveAppointment(a);
	}
	
	@RequestMapping(value="/getAppointmentsByPatient/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Appointment>> getAppointmentsByPatient(@PathVariable int id){
		List<Appointment> appointments = appointmentService.getAppointmentsByPatient(id);
		
		if(appointments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(appointments,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/getFreeAppointmentsByPatient/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Appointment>> getFreeAppointmentsByPatient(@PathVariable int id){
		List<Appointment> appointments = appointmentService.getFreeAppointmentsByPatient(id);
		
		if(appointments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(appointments,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/getAppointmentsByDoctor/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable int id){
		List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(id);
		
		if(appointments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(appointments,HttpStatus.OK);
		}
		
	}
	/*
	@RequestMapping(value = "appointment", method = RequestMethod.GET)
	public void updateAppointments(Pageable page){
		List<AppointmentDTO> dtos = patientClient.updateAppointments();
		
		for(AppointmentDTO dto : dtos) {
			Appointment a = dto.getAppointment;
			
			a.getDoctor().incNumOfPatients;
			appointmentService.saveAppointment(a);
		}
		
	}
	*/

}