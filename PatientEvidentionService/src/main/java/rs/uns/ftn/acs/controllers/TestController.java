package rs.uns.ftn.acs.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping(value = "/private/hello", method = RequestMethod.GET)
	public ResponseEntity<String> sayPrivateHello(){
		return ResponseEntity.ok("Private hello");
	}
	
	@RequestMapping(value = "/public/hello", method = RequestMethod.GET)
	public ResponseEntity<String> sayPublicHello(){
		return ResponseEntity.ok("Public hello");
	}	
}
