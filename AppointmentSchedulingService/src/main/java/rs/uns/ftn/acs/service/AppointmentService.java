package rs.uns.ftn.acs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.dtos.AppointmentDto;
import rs.uns.ftn.acs.models.Appointment;
import rs.uns.ftn.acs.repositories.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepo;
	
	public List<AppointmentDto> getAppointments(){
		List<AppointmentDto> aDtos = new ArrayList<>();
		for(Appointment a: appointmentRepo.findAll()) {
			aDtos.add(new AppointmentDto(a));
		}
		return aDtos;
	}
}
