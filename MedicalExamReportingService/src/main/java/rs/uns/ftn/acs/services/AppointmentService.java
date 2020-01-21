package rs.uns.ftn.acs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.model.Appointment;
import rs.uns.ftn.acs.model.Report;
import rs.uns.ftn.acs.repositories.AppointmentRepository;
import rs.uns.ftn.acs.repositories.ReportRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository repo;
	
	
	public Appointment saveAppointment(Appointment a) {
		return repo.save(a);
	}
	
	public List<Appointment> getAppointmentsByPatient(int id){
		return repo.findAppointmentsByPatient(id);
	}
	
	public List<Appointment> getFreeAppointmentsByPatient(int id){
		return repo.findFreeAppointmentsByPatient(id);
	}
	
	public List<Appointment> getAppointmentsByDoctor(int id){
		return repo.findAppointmentsByDoctor(id);
	}
	
}
