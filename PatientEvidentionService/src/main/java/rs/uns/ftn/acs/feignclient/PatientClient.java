package rs.uns.ftn.acs.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("patient-service")
public interface PatientClient {
	// TODO: Ovo ne radi, treba ga usaglasiti sa timom 1
	@RequestMapping(method = RequestMethod.PUT, value = "/patient", consumes = "application/json")
	ResponseEntity<?> blockPatient();
}
