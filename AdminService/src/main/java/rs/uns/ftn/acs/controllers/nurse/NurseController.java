package rs.uns.ftn.acs.controllers.nurse;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dto.authentication.nurseDTO.NurseDTO;
import rs.uns.ftn.acs.service.NurseService;

@RestController
public class NurseController {
	@Autowired
	private NurseService nurseService;

	@RequestMapping(value = "nurse", method = RequestMethod.GET)
	public ResponseEntity<Page<?>> getAll(Pageable page){
		return nurseService.getNurses(page);
	}
	
	@RequestMapping(value = "nurse/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Integer id){		
		return nurseService.getOne(id);
	}
	
	@RequestMapping(value = "nurse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody @Valid NurseDTO nurse) {
		return nurseService.addNurse(nurse);
	}
	
	@RequestMapping(value = "professionalQualification", method = RequestMethod.GET)
	public ResponseEntity<Page<?>> getProfessionalQualification(Pageable page){
		return nurseService.getProfessionalQualifications(page);
	}
}
