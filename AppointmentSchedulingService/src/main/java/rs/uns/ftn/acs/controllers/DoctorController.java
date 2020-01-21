package rs.uns.ftn.acs.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dtos.DoctorDto;
import rs.uns.ftn.acs.models.Doctor;
import rs.uns.ftn.acs.repositories.DoctorRepository;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired 
	DoctorRepository repo;
	
	@GetMapping
	public ResponseEntity<List<DoctorDto>> getAll() {
		List<Doctor> doctors = repo.findAll();
		List<DoctorDto> dtos = new ArrayList<>();
		for(Doctor doctor: doctors) {
			dtos.add(new DoctorDto(doctor));
		}
		return ResponseEntity.ok(dtos);
	}
}
