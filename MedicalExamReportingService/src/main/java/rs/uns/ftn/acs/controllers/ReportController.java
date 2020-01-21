package rs.uns.ftn.acs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.model.Report;
import rs.uns.ftn.acs.services.ReportService;

import java.util.List;

@RestController
@RequestMapping(value="/report")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addReport(@RequestBody Report r) {
		System.out.println("Id izvjestaja je " + r.getId());
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
