package rs.uns.ftn.acs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.feignclient.PatientClient;
import rs.uns.ftn.acs.model.Appointment;
import rs.uns.ftn.acs.model.Report;
import rs.uns.ftn.acs.repositories.AppointmentRepository;
import rs.uns.ftn.acs.repositories.ReportRepository;

@Service
public class AppointmentService {
	
	private static final String API_KEY = "patient-service";
	
	@Autowired
	AppointmentRepository repo;
	
	@Autowired
	private PatientClient patientClient;
	
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
