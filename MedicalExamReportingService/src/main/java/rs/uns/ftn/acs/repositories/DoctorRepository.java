package rs.uns.ftn.acs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ftn.acs.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	Doctor save(Doctor d);
	
	//Optional<Doctor> findByUsername(String username);
}
