package rs.uns.ftn.acs.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import rs.uns.ftn.acs.authentification.CustomUserDetails;
import rs.uns.ftn.acs.authentification.CustomUserDetailsService;
import rs.uns.ftn.acs.authentification.TokenUtils;
import rs.uns.ftn.acs.models.Patient;


public class LoginService {

		@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenUtils tokenUtils;


	public String login(String username, String password, HttpServletRequest request) {
		// check if user exists
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		return this.tokenUtils.generateToken(customUserDetailsService.loadUserByUsername(username));
	}
	
	public String generateToken(Patient account, HttpServletRequest request) {
		return this.tokenUtils.generateToken(new CustomUserDetails(account));
	}

}
