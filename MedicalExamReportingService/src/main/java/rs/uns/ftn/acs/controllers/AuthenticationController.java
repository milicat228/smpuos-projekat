package rs.uns.ftn.acs.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dto.authentication.AuthenticationRequest;
import rs.uns.ftn.acs.dto.authentication.AuthenticationResponse;
import rs.uns.ftn.acs.services.AuthenticationService;


@RestController
@RequestMapping(value= "/login")
public class AuthenticationController {
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest, HttpServletRequest request){		
		System.out.println("Usao u servis");
		String token = authenticationService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword(), request);
		AuthenticationResponse response = new AuthenticationResponse(token);
		return ResponseEntity.ok(response);
	}
}
