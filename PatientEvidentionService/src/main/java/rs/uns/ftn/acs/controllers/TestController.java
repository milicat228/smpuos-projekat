package rs.uns.ftn.acs.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> validateToken(){
		return ResponseEntity.ok("Hello");
	}
}
