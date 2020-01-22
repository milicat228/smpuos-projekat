package rs.uns.ftn.acs.security.userdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rs.uns.ftn.acs.model.UserAccount;


public class CustomUserDetails extends UserAccount implements UserDetails {
	private static final long serialVersionUID = -7409628553986490588L;
	private Boolean isApi = false;
	
	public CustomUserDetails(UserAccount account) {
		super();
		this.id = account.getId();
		this.username = account.getUsername();
		this.email = account.getEmail();
		this.active = account.getActive();
		this.password = account.getPassword();
		this.lastPasswordChangeDate = account.getLastPasswordChangeDate();
		this.registrationDate = account.getRegistrationDate();
		this.authorities = account.getUserAuthorities();
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
			return super.getUserAuthorities()
					.stream()
					.map(authority -> new SimpleGrantedAuthority("ROLE_" + authority.getAuthority()))
					.collect(Collectors.toSet());
		}
		else {
			List<SimpleGrantedAuthority> auth = new ArrayList<SimpleGrantedAuthority>();
			auth.add(new SimpleGrantedAuthority("ROLE_API"));
			return auth;
		}
		
	}
}
