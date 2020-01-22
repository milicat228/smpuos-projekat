package rs.uns.ftn.acs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ftn.acs.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findByLBO(String lbo);
	Optional<Patient> findById(int id);
	
}
