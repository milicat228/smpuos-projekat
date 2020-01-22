package rs.uns.ftn.acs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.model.Doctor;
import rs.uns.ftn.acs.repositories.DoctorRepository;
@Service
public class DoctorService {
	@Autowired
	DoctorRepository repo;
	
	
	public Doctor saveDoctor(Doctor d) {
		return repo.save(d);
	}
	
	
}
