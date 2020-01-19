package rs.uns.ftn.acs.feignclient.nurse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.uns.ftn.acs.dto.authentication.nurseDTO.NurseDTO;

@FeignClient("nurse-service")
public interface NurseClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/nurse")
	ResponseEntity<Page<?>> getNurses(@RequestHeader("API-Key") String authHeader, Pageable page);
	
	@RequestMapping(method = RequestMethod.GET, value = "/nurse/{id}")
	ResponseEntity<?> getNurse(@RequestHeader("API-Key") String authHeader, @PathVariable("id") Integer id);

	@RequestMapping(method = RequestMethod.POST, value = "/nurse", consumes = "application/json")
	ResponseEntity<?> addNurse(@RequestHeader("API-Key") String authHeader, NurseDTO nurse);
	
	@RequestMapping(method = RequestMethod.GET, value = "/professionalQualification")
	ResponseEntity<Page<?>> getProfessionalQualifications(@RequestHeader("API-Key") String authHeader, Pageable page);
}
