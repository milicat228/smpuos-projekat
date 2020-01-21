package rs.uns.ftn.acs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.model.Report;
import rs.uns.ftn.acs.repositories.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	ReportRepository repo;
	
	
	public Report saveReport(Report r) {
		return repo.save(r);
	}
	public List<Report> getReportsByPatient(int id){
		return repo.findReportsByPatient(id);
	}
	
	
}
