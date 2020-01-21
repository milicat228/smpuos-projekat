package rs.uns.ftn.acs.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.model.UserAccount;
import rs.uns.ftn.acs.repositories.UserAccountRepository;


@Service
public class ProfileService {
	@Autowired
	private UserAccountRepository userAccountRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Find user with username. 
	 * @param username
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public UserAccount findByUsername(String username) throws ResourceNotFoundException {
		Optional<UserAccount> optionalUser = userAccountRepository.findByUsername(username);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new ResourceNotFoundException(username);
	}

	/**
	 * Change user password.
	 * @param username
	 * @param oldPassword
	 * @param newPassword
	 * @return return user obejct with changed password if successful, otherwise null
	 * @throws ResourceNotFoundException
	 */
	public UserAccount changePassword(String username, String oldPassword, String newPassword) throws ResourceNotFoundException {
		UserAccount user = findByUsername(username);
		//check if password matched current password
		if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
			return null;
		}
		//save new password
		user.setPassword(passwordEncoder.encode(newPassword));
		userAccountRepository.save(user);
		return user;
	}

}
