package rs.uns.ftn.acs.controllers.profile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ftn.acs.dto.authentication.AuthenticationResponse;
import rs.uns.ftn.acs.dto.profile.PasswordChangeDTO;
import rs.uns.ftn.acs.entity.UserAccount;
import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.service.authentication.AuthenticationService;
import rs.uns.ftn.acs.service.profile.ProfileService;

@RestController
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ResponseEntity<UserAccount> getProfile() throws ResourceNotFoundException {	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return new ResponseEntity<UserAccount>(profileService.findByUsername(username), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ResponseEntity<?> changePassword(@Valid @RequestBody PasswordChangeDTO passwordInfo,	HttpServletRequest request) throws ResourceNotFoundException {
		//get username
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		//try password change
		UserAccount account = profileService.changePassword(username, passwordInfo.getOldPassword(), passwordInfo.getNewPassword());
		if (account != null) {
			//generate new token
			String token = authenticationService.generateToken(account, request);
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(token), HttpStatus.OK);
		} else {
			//passwords don't match
			return new ResponseEntity<String>("Old password is incorrect.", HttpStatus.BAD_REQUEST);
		}
	}
}
