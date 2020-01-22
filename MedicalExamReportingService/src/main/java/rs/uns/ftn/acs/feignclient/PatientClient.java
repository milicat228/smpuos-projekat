package rs.uns.ftn.acs.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.uns.ftn.acs.dtos.AppointmentDTO;



@FeignClient("patient-service")
public interface PatientClient {
	// TODO: Ovo ne radi, treba ga usaglasiti sa timom 1
	@RequestMapping(method = RequestMethod.GET, value = "/appointments", consumes = "application/json")
	List<AppointmentDTO> updateAppointments();
}
