package rs.uns.ftn.acs.authentification;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthenticationFilter extends OncePerRequestFilter {
	private static final String API_KEY = "patient-service";
	private CustomUserDetailsService customUserDetailsService;
	private TokenUtils tokenUtils;
	
	public AuthenticationFilter(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
		tokenUtils = new TokenUtils();
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String authToken = tokenUtils.getToken(request);
		if (authToken != null) {
			String username = tokenUtils.getUsernameFromToken(authToken);
			if (username != null) {
				UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
				if (tokenUtils.validateToken(authToken, userDetails)) {
					TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
					authentication.setToken(authToken);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		
		
		String apiHeader = request.getHeader("API-Key");
		if(API_KEY.equals(apiHeader)) {
			APIKeyBasedAuthentication apiAuthentication = new APIKeyBasedAuthentication(new CustomUserDetails());
			SecurityContextHolder.getContext().setAuthentication(apiAuthentication);
		}
		filterChain.doFilter(request, response);
	}

}