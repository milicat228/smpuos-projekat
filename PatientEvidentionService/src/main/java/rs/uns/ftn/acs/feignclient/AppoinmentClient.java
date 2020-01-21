package rs.uns.ftn.acs.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.uns.ftn.acs.dto.patient.AppointmentDTO;

@FeignClient("doctor-service")
public interface AppoinmentClient {

	// TODO: Ovo ne radi, treba ga usaglasiti sa timom 3
	@RequestMapping(method = RequestMethod.GET, value = "/appoinment")
	ResponseEntity<List<AppointmentDTO>> getAppointments();

	// TODO: Ovo ne radi, treba ga usaglasiti sa timom 3
	@RequestMapping(method = RequestMethod.PUT, value = "/appoinment", consumes = "application/json")
	ResponseEntity<?> confirmArrival();
}
