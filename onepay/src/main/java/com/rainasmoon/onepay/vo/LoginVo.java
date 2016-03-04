package com.rainasmoon.onepay.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginVo {

	@NotEmpty(message = "{not.null}")
	protected String account;

	@NotEmpty(message = "{not.null}")
	protected String password;

	@NotEmpty(message = "{not.null}")
	protected String checkCode;

	protected String error;

	@Override
	public String toString() {
		return "LoginVo [account=" + account + ", password=" + password + ", checkCode=" + checkCode + ", error=" + error + "]";
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
