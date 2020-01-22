package rs.uns.ftn.acs.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import rs.uns.ftn.acs.security.userdetails.CustomUserDetails;
import rs.uns.ftn.acs.security.userdetails.CustomUserDetailsService;

public class AuthenticationFilter extends OncePerRequestFilter {
	private static final String API_KEY = "nurse-service";
	private CustomUserDetailsService customUserDetailsService;
	private TokenUtils tokenUtils;
	
	public AuthenticationFilter(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
		tokenUtils = new TokenUtils();
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//check if its user
		String authToken = tokenUtils.getToken(request);
		if (authToken != null) {
			// pronadji username u tokenu
			String username = tokenUtils.getUsernameFromToken(authToken);
			if (username != null) {
				// pronadji korisnika sa datim mejlom
				UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
				// proveri da li je prosledjeni token validan
				if (tokenUtils.validateToken(authToken, userDetails)) {
					// kreiraj autentifikaciju
					TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
					authentication.setToken(authToken);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		
		//check if its other service
		String apiHeader = request.getHeader("API-Key");
		if(API_KEY.equals(apiHeader)) {
			APIKeyBasedAuthentication apiAuthentication = new APIKeyBasedAuthentication(new CustomUserDetails());
			SecurityContextHolder.getContext().setAuthentication(apiAuthentication);
		}
		filterChain.doFilter(request, response);
	}

}
