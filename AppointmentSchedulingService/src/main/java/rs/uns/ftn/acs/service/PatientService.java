package rs.uns.ftn.acs.service;

import java.net.PasswordAuthentication;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.models.Patient;
import rs.uns.ftn.acs.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repo;
	public Page<Patient> findAll(Pageable pageable) {
		
		return repo.findAll(pageable);
	}

	public Patient findOne(Integer id) {
		Optional<Patient> optionalUser = repo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new RuntimeException(id.toString());

	}

	public Patient save(Patient entity) {
		entity.setPassword(entity.getPassword());
		return repo.save(entity);
	}
}
