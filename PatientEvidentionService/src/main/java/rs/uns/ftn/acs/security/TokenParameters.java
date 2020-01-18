package rs.uns.ftn.acs.security;



public class TokenParameters {
	public static final String HEADER = "Authorization";
	public static final String PREFIX = "Bearer";
	public static final Integer EXPIRATION = 24*60*60;
	public static final String SECRET = "tajna";
	
	/*AUDIENCE TYPES*/
	public static final String AUDIENCE_UNKNOWN = "unknown";
	public static final String AUDIENCE_WEB = "web";
	public static final String AUDIENCE_MOBILE = "mobile";
	public static final String AUDIENCE_TABLET = "tablet";
}
