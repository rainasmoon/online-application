package com.rainasmoon.onepay.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



public class RegistorVo{


	@NotEmpty(message="{not.null}")
	@Size(max = 100, message="{error.too.lang}")
	protected String email;

	@NotEmpty(message="{not.null}")
	@Size(max = 100, message="{error.too.lang}")
	protected String password;

	@NotEmpty(message="{not.null}")
	@Size(max = 100, message="{error.too.lang}")
	protected String confirmPassword;

	@Size(max = 20, message="{error.too.lang}")
	protected String qq;

	@Size(max = 20, message="{error.too.lang}")
	protected String mobile;

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}