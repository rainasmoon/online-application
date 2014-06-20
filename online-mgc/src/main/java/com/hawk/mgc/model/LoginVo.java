package com.hawk.mgc.model;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginVo {

	@NotEmpty(message = "{not.null}")
	protected String userName;

	@NotEmpty(message = "{not.null}")
	protected String password;

	protected String error;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
