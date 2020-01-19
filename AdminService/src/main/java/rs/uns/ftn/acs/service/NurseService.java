package rs.uns.ftn.acs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.dto.authentication.nurseDTO.NurseDTO;
import rs.uns.ftn.acs.feignclient.nurse.NurseClient;

@Service
public class NurseService {
	private static final String API_KEY = "nurse-service";

	@Autowired
	private NurseClient nurseClient;
		
	public ResponseEntity<Page<?>> getNurses(Pageable page){
		return nurseClient.getNurses(API_KEY, page);
	}
	
	public ResponseEntity<Page<?>> getProfessionalQualifications(Pageable page){
		return nurseClient.getProfessionalQualifications(API_KEY, page);
	}
	
	public ResponseEntity<?> getOne(Integer id){
		return nurseClient.getNurse(API_KEY, id);
	}
	
	public ResponseEntity<?> addNurse(NurseDTO nurse){
		return nurseClient.addNurse(API_KEY, nurse);
	}
}
