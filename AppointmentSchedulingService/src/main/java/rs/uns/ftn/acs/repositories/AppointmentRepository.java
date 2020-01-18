package rs.uns.ftn.acs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.uns.ftn.acs.models.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	public Appointment findByAsdf(String asdf);
}
