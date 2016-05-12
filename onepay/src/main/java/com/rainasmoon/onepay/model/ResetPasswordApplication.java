package com.rainasmoon.onepay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reset_password_applications")
public class ResetPasswordApplication extends BaseEntity {

	@Column(name = "login_account")
	private String loginAccount;
	@Column(name = "description")
	private String description;
	@Column(name = "password1")
	private String password1;
	@Column(name = "password2")
	private String password2;
	@Column(name = "password3")
	private String password3;
	@Column(name = "receive_reset_email")
	private String receiveResetEmail;

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getPassword3() {
		return password3;
	}

	public void setPassword3(String password3) {
		this.password3 = password3;
	}

	public String getReceiveResetEmail() {
		return receiveResetEmail;
	}

	public void setReceiveResetEmail(String receiveResetEmail) {
		this.receiveResetEmail = receiveResetEmail;
	}
}
