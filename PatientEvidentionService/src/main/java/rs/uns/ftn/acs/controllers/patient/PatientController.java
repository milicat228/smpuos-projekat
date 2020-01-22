package rs.uns.ftn.acs.controllers.patient;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dto.patient.PatientDTO;
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
	
	@PreAuthorize("hasAnyRole('NURSE')")
	@RequestMapping(value="/patient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> save(@RequestBody @Valid PatientDTO patientDTO) throws ResourceNotFoundException{
		Patient newPatient = patientDTO.getPatient();
		Patient createdPatient = patientService.save(newPatient);
		return new ResponseEntity<Patient>(createdPatient, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('NURSE')")
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> changePassword(@PathVariable int id, @RequestBody @Valid PatientDTO patientDTO) throws ResourceNotFoundException{
		Patient patient = patientDTO.getPatient();
		Patient updatePatient=patientService.findById(id);
		
		updatePatient.setFirstname(patient.getFirstname());
		updatePatient.setLastname(patient.getLastname());
		updatePatient.setJMBG(patient.getJMBG());
		updatePatient.setZK(patient.getZK());
		updatePatient.setLBO(patient.getLBO());
		updatePatient.setInsurenceBase(patient.getInsurenceBase());
		updatePatient.setInsurencePayer(patient.getInsurencePayer());
		updatePatient.setAddress(patient.getAddress());
		updatePatient.setPhoneNumber(patient.getPhoneNumber());
		updatePatient.setDateOfBirth(patient.getDateOfBirth());
		updatePatient.setGender(patient.getGender());
		
		patientService.save(updatePatient);

		return new ResponseEntity<Patient>(updatePatient, HttpStatus.OK);
	}

}
