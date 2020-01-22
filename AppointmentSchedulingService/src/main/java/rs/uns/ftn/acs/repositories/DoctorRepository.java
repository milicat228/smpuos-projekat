package rs.uns.ftn.acs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.uns.ftn.acs.models.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
