package rs.uns.ftn.acs.controllers.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.entity.Patient;
import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.service.patient.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@PreAuthorize("hasAnyRole('NURSE')")
	@RequestMapping(value = "/patient/{lbo}", method = RequestMethod.GET)
	public ResponseEntity<Patient> getPatient(@PathVariable String lbo) throws ResourceNotFoundException{
		return new ResponseEntity<Patient>(patientService.findByLBO(lbo), HttpStatus.OK);
	}

}
