package com.rainasmoon.onepay.model;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginVo {

	@NotEmpty(message="{not.null}")
	protected String email;

	@NotEmpty(message="{not.null}")
	protected String password;

	@NotEmpty(message="{not.null}")
	protected String checkCode;
	
	protected String error;

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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
