package rs.uns.ftn.acs.controllers.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dto.crud.NurseDTO;
import rs.uns.ftn.acs.entity.Nurse;
import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.service.crud.NurseService;

@RestController
@RequestMapping("nurse")
public class NurseController{
	@Autowired
	private NurseService nurseService;
	
	@PreAuthorize("hasAnyRole('API')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Nurse>> getAll(Pageable pageable){
		Page<Nurse> page = nurseService.findAll(pageable);
		return new ResponseEntity<Page<Nurse>>(page, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('API')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Nurse> getOne(@PathVariable Integer id) throws ResourceNotFoundException{		
		return new ResponseEntity<Nurse>(nurseService.findOne(id), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('API')")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Nurse> save(@RequestBody NurseDTO nurseDTO) {
		Nurse newNurse = nurseDTO.getNurse();
		Nurse created = nurseService.save(newNurse);
		return new ResponseEntity<Nurse>(created, HttpStatus.OK);
	}
}
