package com.hawk.application.model;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginVo {

	@NotEmpty
	protected String email;

	@NotEmpty
	protected String password;

	@NotEmpty
	protected String checkCode;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
}
