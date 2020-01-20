package rs.uns.ftn.acs.dtos;

import javax.validation.constraints.NotBlank;

public class RequestDto {
	@NotBlank(message = "Username:")
	private String username;

	@NotBlank(message = "Password:")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
