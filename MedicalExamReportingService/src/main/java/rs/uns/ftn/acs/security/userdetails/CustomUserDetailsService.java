package rs.uns.ftn.acs.security.userdetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.model.UserAccount;
import rs.uns.ftn.acs.repositories.UserAccountRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserAccount> optionalUser = userAccountRepository.findByUsername(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username " + username  + "not found."));
		return optionalUser.map(CustomUserDetails::new).get();
	}

}
