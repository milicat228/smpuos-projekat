package rs.uns.ftn.acs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ftn.acs.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
