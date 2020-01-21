package rs.uns.ftn.acs.repositories;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.uns.ftn.acs.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {
	
	Report save(Report r);
	
	@Query("select report from Report report where report.patient.idPat = :id")
	List<Report> findReportsByPatient(@Param("id") int id);
	
	
	

}
