package rs.uns.ftn.acs.controllers.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.entity.ProfessionalQualification;
import rs.uns.ftn.acs.service.crud.ProfessionalQualificationService;

@RestController
@RequestMapping("professionalQualification")
public class ProfessionalQualificationController {
	@Autowired
	private ProfessionalQualificationService professionalQualificationService;
	
	@PreAuthorize("hasAnyRole('API')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProfessionalQualification>> getAll(Pageable pageable){
		Page<ProfessionalQualification> page = professionalQualificationService.findAll(pageable);
		return new ResponseEntity<Page<ProfessionalQualification>>(page, HttpStatus.OK);
	}
}
