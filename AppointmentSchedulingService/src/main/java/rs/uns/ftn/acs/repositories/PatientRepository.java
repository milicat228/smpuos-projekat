package rs.uns.ftn.acs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ftn.acs.models.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findByUsername(String username);
}
