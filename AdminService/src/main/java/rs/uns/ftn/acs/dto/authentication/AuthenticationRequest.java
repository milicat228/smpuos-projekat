package rs.uns.ftn.acs.dto.authentication;

import javax.validation.constraints.NotBlank;

public class AuthenticationRequest {
	@NotBlank(message = "Please, enter your username.")
	private String username;

	@NotBlank(message = "Please, enter your password.")
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
