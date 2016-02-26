package com.hawk.application.model;

import javax.validation.constraints.Size;

public class ChangeUserInformationVo {

	@Size(max = 20, message="{error.too.lang}")
	protected String qq;

	@Size(max = 20, message="{error.too.lang}")
	protected String mobile;
	
	@Size(max = 20, message="{error.too.lang}")
	protected String contactType;
	
	@Size(max = 100, message="{error.too.lang}")
	protected String contactName;
	
	@Size(max = 20, message="{error.too.lang}")
	protected String contactIdNumber;
	
	@Size(max = 100, message="{error.too.lang}")
	protected String bankName;

	private Dictionary province;

	private Dictionary city;
	
	@Size(max = 200, message="{error.too.lang}")
	protected String branchName;
	
	@Size(max = 50, message="{error.too.lang}")
	protected String accountNumber;
	
	protected String idCardFrontPath;
	
	protected String idCardBackPath;

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

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactIdNumber() {
		return contactIdNumber;
	}

	public void setContactIdNumber(String contactIdNumber) {
		this.contactIdNumber = contactIdNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Dictionary getProvince() {
		return province;
	}

	public void setProvince(Dictionary province) {
		this.province = province;
	}

	public Dictionary getCity() {
		return city;
	}

	public void setCity(Dictionary city) {
		this.city = city;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIdCardFrontPath() {
		return idCardFrontPath;
	}

	public void setIdCardFrontPath(String idCardFrontPath) {
		this.idCardFrontPath = idCardFrontPath;
	}

	public String getIdCardBackPath() {
		return idCardBackPath;
	}

	public void setIdCardBackPath(String idCardBackPath) {
		this.idCardBackPath = idCardBackPath;
	}	
}
