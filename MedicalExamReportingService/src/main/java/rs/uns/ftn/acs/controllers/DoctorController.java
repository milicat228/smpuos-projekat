package rs.uns.ftn.acs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dtos.DoctorDTO;
import rs.uns.ftn.acs.model.Doctor;
//import rs.uns.ftn.acs.services.DoctorService;
import rs.uns.ftn.acs.services.DoctorService;

@RestController
@RequestMapping(value="/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService docService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addDoctor(@RequestBody DoctorDTO dto) {
		Doctor d = dto.getDoc();
		
		d.setPassword(encoder.encode(d.getPassword()));
		//d.getPassword();
		docService.saveDoctor(d);
		
	}
	
	

}
