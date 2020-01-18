package rs.uns.ftn.acs.security;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import rs.uns.ftn.acs.security.userdetails.CustomUserDetails;

@Component
public class TokenUtils {
	private final Log LOGGER = LogFactory.getLog(getClass());
		
	private String generateAudience(Device device) {
		String audience = TokenParameters.AUDIENCE_UNKNOWN;
		if(device == null) {
			return audience;
		}
		if (device.isNormal()) {
			audience = TokenParameters.AUDIENCE_WEB;
		} else if (device.isTablet()) {
			audience = TokenParameters.AUDIENCE_TABLET;
		} else if (device.isMobile()) {
			audience = TokenParameters.AUDIENCE_MOBILE;
		}
		return audience;
	}
	
	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + TokenParameters.EXPIRATION * 1000);
	}
	
	private String generateToken(Map<String, Object> claims) {
		try {
			return Jwts.builder().setClaims(claims).setExpiration(this.generateExpirationDate())
					.signWith(SignatureAlgorithm.HS512, TokenParameters.SECRET.getBytes("UTF-8")).compact();
		} catch (UnsupportedEncodingException ex) {
			// didn't want to have this method throw the exception, would rather log it and
			// sign the token like it was before
			LOGGER.warn(ex.getMessage());
			return Jwts.builder().setClaims(claims).setExpiration(this.generateExpirationDate())
					.signWith(SignatureAlgorithm.HS512, TokenParameters.SECRET).compact();
		}
	}
	
	/**
	 * Creates new token for user. Included claims are role, username, device and date of creation.
	 * @param userDetails basic user details containing username and password
	 * @param device for which token is being created
	 * @return
	 */
	public String generateToken(UserDetails userDetails, Device device) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("roles", userDetails.getAuthorities());			
		claims.put("sub", userDetails.getUsername());
		claims.put("audience", this.generateAudience(device));
		claims.put("created", new Date(System.currentTimeMillis()));
		return this.generateToken(claims);
	}
	
	private Date generateCurrentDate() {
		return new Date(System.currentTimeMillis());
	}
	
	/**
	 * @param token
	 * @return username hidden in token
	 */
	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	/**
	 * @param token
	 * @return date when token was created
	 */
	public Date getCreatedDateFromToken(String token) {
		Date created;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			created = new Date((Long) claims.get("created"));
		} catch (Exception e) {
			created = null;
		}
		return created;
	}

	/**
	 * @param token
	 * @return date when token will expire
	 */
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	/**
	 * @param token
	 * @return for which device is token
	 */
	public String getAudienceFromToken(String token) {
		String audience;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			audience = (String) claims.get("audience");
		} catch (Exception e) {
			audience = null;
		}
		return audience;
	}

	/**
	 * @param token
	 * @return what is stored in token
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(TokenParameters.SECRET.getBytes("UTF-8")).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	
	private Boolean isTokenExpired(String token) {
		final Date expiration = this.getExpirationDateFromToken(token);
		return expiration.before(this.generateCurrentDate());
	}
	
	private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}
	
	/**
	 * Checks if token is valid. 
	 * @param token
	 * @param userDetails
	 * @return
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		CustomUserDetails user = (CustomUserDetails) userDetails;
		final String username = this.getUsernameFromToken(token);
		final Date created = this.getCreatedDateFromToken(token);
		return (username.equals(user.getUsername()) && !(this.isTokenExpired(token))
				&& !(this.isCreatedBeforeLastPasswordReset(created, user.getLastPasswordChangeDate())));
	}
	
	/**
	 * Finds token in HTTP request.
	 * @param request
	 * @return
	 */
	public String getToken(String authHeader) {
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}
		return null;
	}
	
	public String getToken(HttpServletRequest request) {
		String authHeader = request.getHeader(TokenParameters.HEADER);
		return getToken(authHeader);
	}
}
