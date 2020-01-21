package rs.uns.ftn.acs.authentification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import rs.uns.ftn.acs.models.Patient;

public class CustomUserDetails extends Patient implements UserDetails {
	private static final long serialVersionUID = -7409628553986490588L;
	private Boolean isApi = false;
	
	public CustomUserDetails(Patient account) {
		super();
		this.id = account.getId();
		this.username = account.getUsername();
		this.email = account.getEmail();
		this.active = account.getActive();
		this.password = account.getPassword();
		this.lastPasswordChangeDate = account.getLastPasswordChangeDate();
		this.registrationDate = account.getRegistrationDate();
	
	}
	
	public CustomUserDetails() {
		this.active = true;
		this.isApi = true;
	}
		
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return super.getActive();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {	
		if(!isApi) {
			Set<GrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			return authorities;
		}
		else {
			List<SimpleGrantedAuthority> auth = new ArrayList<SimpleGrantedAuthority>();
			auth.add(new SimpleGrantedAuthority("ROLE_API"));
			return auth;
		}
		
	}
}
