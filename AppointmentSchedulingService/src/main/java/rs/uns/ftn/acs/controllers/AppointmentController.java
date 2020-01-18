package rs.uns.ftn.acs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dtos.AppointmentDto;
import rs.uns.ftn.acs.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping
	public List<AppointmentDto> getAppointments() {
		return appointmentService.getAppointments();
	}
}
