package rs.uns.ftn.acs.dto.profile;

import javax.validation.constraints.NotBlank;

public class PasswordChangeDTO {
	@NotBlank(message = "Please, enter old password.")
	private String oldPassword;
	@NotBlank(message = "Please, enter new password.")
	private String newPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
