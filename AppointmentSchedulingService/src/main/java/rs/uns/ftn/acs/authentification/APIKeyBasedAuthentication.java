package rs.uns.ftn.acs.authentification;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

	public class APIKeyBasedAuthentication extends AbstractAuthenticationToken {
		private final UserDetails principle;

		private static final long serialVersionUID = 1L;
		
		public APIKeyBasedAuthentication(UserDetails principle) {
			super(principle.getAuthorities());
			this.principle = principle;
		}

		@Override
		public Object getCredentials() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getPrincipal() {
			return principle;
		}

		@Override
		public boolean isAuthenticated() {
			return true;
		}

}
