package rs.uns.ftn.acs.controllers;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;
	import rs.uns.ftn.acs.dtos.PatientDto;
import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.models.Patient;
import rs.uns.ftn.acs.service.PatientService;


	@RestController
	@RequestMapping("nurse")
	public class PatientController {
		@Autowired
		private PatientService patientService;
		
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<Page<Patient>> getAll(Pageable pageable){
			Page<Patient> page = patientService.findAll(pageable);
			return new ResponseEntity<Page<Patient>>(page, HttpStatus.OK);
		}
	
		@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
		public ResponseEntity<Patient> getOne(@PathVariable Integer id) throws ResourceNotFoundException{		
			return new ResponseEntity<Patient>(patientService.findOne(id), HttpStatus.OK);
		}

		@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Patient> save(@RequestBody PatientDto patientDto) {
			Patient newPatient = patientDto.getPatient();
			Patient created = patientService.save(newPatient);
			return new ResponseEntity<Patient>(created, HttpStatus.OK);
		}
	}

