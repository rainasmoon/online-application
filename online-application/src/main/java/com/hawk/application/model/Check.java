package com.hawk.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "checks")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Check extends BaseEntity {

	@Column(name = "contact_name")
	protected String contactName;

	@Column(name = "contact_id_number")
	protected String contactIdNumber;

	@Column(name = "bank_name")
	protected String bankName;

	@Column(name = "bank_address")
	protected String bankAddress;

	@Column(name = "account_number")
	protected String accountNumber;

	@NotNull
	@Min(100)
	@Column(name = "apply_amount")
	protected Double applyAmount;

	@Column(name = "status")
	protected String status;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "created_date")
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "created_by")
	protected Integer createdBy;

	@Column(name = "updated_by")
	protected Integer updatedBy;

	@Transient
	protected Double remainder;

	@Transient
	protected String error;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Double getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(Double applyAmount) {
		this.applyAmount = applyAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Double getRemainder() {
		return remainder;
	}

	public void setRemainder(Double remainder) {
		this.remainder = remainder;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
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

}
