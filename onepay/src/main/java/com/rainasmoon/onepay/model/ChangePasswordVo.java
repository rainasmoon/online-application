package com.rainasmoon.onepay.model;

import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePasswordVo {

	@NotEmpty(message="{not.null}")
	@Size(max = 100, message="{error.too.lang}")
	protected String oldPassword;

	@NotEmpty(message="{not.null}")
	@Size(max = 100, message="{error.too.lang}")
	protected String newPassword;

	@NotEmpty(message="{not.null}")
	@Size(max = 100, message="{error.too.lang}")
	protected String confirmPassword;
	
	@Transient
	protected String error;

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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
