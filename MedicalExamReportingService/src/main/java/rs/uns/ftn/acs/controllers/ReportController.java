package rs.uns.ftn.acs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.model.Doctor;
import rs.uns.ftn.acs.model.Report;
import rs.uns.ftn.acs.model.UserAccount;
import rs.uns.ftn.acs.services.ProfileService;
import rs.uns.ftn.acs.services.ReportService;

import java.util.List;

@RestController
@RequestMapping(value="/report")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addReport(@RequestBody Report r) throws ResourceNotFoundException {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
		String username=auth.getName();
		UserAccount account=profileService.findByUsername(username);
		r.setDoctor((Doctor)account);
		
		reportService.saveReport(r);
	}
	
	@RequestMapping(value="/getReportsByPatient/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Report>> getReportsByPatient(@PathVariable int id){
		List<Report> reports = reportService.getReportsByPatient(id);
		
		if(reports == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(reports,HttpStatus.OK);
		}
		
		
	}
	
	

}
