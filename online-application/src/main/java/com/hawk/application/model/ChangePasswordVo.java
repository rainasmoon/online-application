package com.hawk.application.model;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePasswordVo {

	@NotEmpty
	protected String oldPassword;

	@NotEmpty
	protected String newPassword;

	@NotEmpty
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
