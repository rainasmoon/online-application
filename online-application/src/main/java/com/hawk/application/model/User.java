package com.hawk.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(name = "email")
	@NotEmpty(message="{not.null}")
	@Size(max = 100, message="{error.too.lang}")
	protected String email;

	@Column(name = "password")
	@NotEmpty(message="{not.null}")
	@Size(max = 100, message="{error.too.lang}")
	protected String password;

	@Transient
	@NotEmpty(message="{not.null}")
	protected String confirmPassword;

	@Column(name = "qq")
	@Size(max = 20, message="{error.too.lang}")
	protected String qq;

	@Column(name = "mobile")
	@Size(max = 20, message="{error.too.lang}")
	protected String mobile;
	
	@Column(name = "contact_type")
	@Size(max = 20, message="{error.too.lang}")
	protected String contactType;
	
	@Column(name = "contact_name")
	@Size(max = 100, message="{error.too.lang}")
	protected String contactName;
	
	@Column(name = "contact_id_number")
	@Size(max = 20, message="{error.too.lang}")
	protected String contactIdNumber;
	
	@Column(name = "bank_name")
	@Size(max = 100, message="{error.too.lang}")
	protected String bankName;
	
	@Column(name = "province_id")
	protected Integer provinceId;
	
	@Column(name = "city_id")
	protected Integer cityId;
	
	@Column(name = "branch_name")
	@Size(max = 200, message="{error.too.lang}")
	protected String branchName;
	
	@Column(name = "account_number")
	@Size(max = 50, message="{error.too.lang}")
	protected String accountNumber;
	
	@Column(name = "id_card_front_path")
	protected String idCardFrontPath;
	
	@Column(name = "id_card_back_path")
	protected String idCardBackPath;	

	@Column(name = "created_date")
	protected Date createdDate;

	@Column(name = "updated_date")
	protected Date updatedDate;

	@Column(name = "created_by")
	protected Integer createdBy;

	@Column(name = "updated_by")
	protected Integer updatedBy;
	
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
