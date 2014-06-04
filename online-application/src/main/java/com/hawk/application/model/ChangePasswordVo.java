package com.hawk.application.model;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePasswordVo {

	@NotEmpty(message="{not.null}")
	protected String oldPassword;

	@NotEmpty(message="{not.null}")
	protected String newPassword;

	@NotEmpty(message="{not.null}")
	protected String confirmPassword;

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
