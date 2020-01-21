package rs.uns.ftn.acs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.uns.ftn.acs.model.Appointment;
import rs.uns.ftn.acs.model.Report;

public interface AppointmentRepository extends JpaRepository<Report, Integer> {
	
	Appointment save(Appointment a);
	
	@Query("select appointment from Appointment appointment where appointment.patient.idPat = :id")
	List<Appointment> findAppointmentsByPatient(@Param("id") int id);
	
	@Query("select appointment from Appointment appointment where appointment.patient.idPat = :id and free=1")
	List<Appointment> findFreeAppointmentsByPatient(@Param("id") int id);
	
	@Query("select appointment from Appointment appointment where appointment.doctor.id = :id")
	List<Appointment> findAppointmentsByDoctor(@Param("id") int id);
	
	
}