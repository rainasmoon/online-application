package com.hawk.mgc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "package_details")
public class MgcPackageDetail extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "package_id")
	protected MgcPackage mgcPackage;

	@Column(name = "installations")
	protected Integer installations;

	@Column(name = "activations")
	protected Integer activations;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "created_date")
	protected Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "updated_date")
	protected Date updatedDate;

	@Column(name = "created_by")
	protected Integer createdBy;

	@Column(name = "updated_by")
	protected Integer updatedBy;

	@Transient
	protected String error;

	public MgcPackage getMgcPackage() {
		return mgcPackage;
	}

	public void setMgcPackage(MgcPackage mgcPackage) {
		this.mgcPackage = mgcPackage;
	}

	public Integer getInstallations() {
		return installations;
	}

	public void setInstallations(Integer installations) {
		this.installations = installations;
	}

	public Integer getActivations() {
		return activations;
	}

	public void setActivations(Integer activations) {
		this.activations = activations;
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
