package rs.uns.ftn.acs.authentification;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.models.Patient;
import rs.uns.ftn.acs.repositories.PatientRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Patient> optionalUser = patientRepository.findByUsername(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username " + username  + "not found."));
		return optionalUser.map(CustomUserDetails::new).get();
	}

}