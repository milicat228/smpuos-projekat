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

import rs.uns.ftn.acs.dtos.RequestDto;
import rs.uns.ftn.acs.dtos.ResponseDto;
import rs.uns.ftn.acs.service.LoginService;



@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> login(@RequestBody @Valid RequestDto authenticationRequest, HttpServletRequest request){		
		String token = loginService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword(), request);
		ResponseDto response = new ResponseDto(token);
		return ResponseEntity.ok(response);
	}
}

