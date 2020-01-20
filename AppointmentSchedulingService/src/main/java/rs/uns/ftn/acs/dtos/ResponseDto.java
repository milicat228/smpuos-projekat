package rs.uns.ftn.acs.dtos;

public class ResponseDto {
	private String token;
	
	public ResponseDto() {
	}

	public ResponseDto(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
