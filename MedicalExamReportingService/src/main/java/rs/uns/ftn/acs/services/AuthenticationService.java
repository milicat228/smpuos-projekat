package rs.uns.ftn.acs.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.model.UserAccount;
import rs.uns.ftn.acs.security.DeviceProvider;
import rs.uns.ftn.acs.security.TokenUtils;
import rs.uns.ftn.acs.security.userdetails.CustomUserDetails;
import rs.uns.ftn.acs.security.userdetails.CustomUserDetailsService;

@Service
public class AuthenticationService {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenUtils tokenUtils;
	@Autowired
	private DeviceProvider deviceProvider;

	public String login(String username, String password, HttpServletRequest request) {
		// check if user exists
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		// find device
		Device device = deviceProvider.getCurrentDevice(request);
		return this.tokenUtils.generateToken(customUserDetailsService.loadUserByUsername(username), device);
	}
	
	public String generateToken(UserAccount account, HttpServletRequest request) {
		Device device = deviceProvider.getCurrentDevice(request);
		return this.tokenUtils.generateToken(new CustomUserDetails(account), device);
	}
}
