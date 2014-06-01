package com.hawk.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "applications")
public class Application extends BaseEntity {

	@Column(name = "application_id")
	protected String applicationId;

	@Column(name = "application_name")
	@NotEmpty
	protected String applicationName;

	@Column(name = "application_platform")
	@NotEmpty
	protected String applicationPlatform;

	@Column(name = "application_package_name")
	@NotEmpty
	protected String applicationPackageName;

	@Column(name = "status")
	protected String status;

	@Column(name = "created_date")
	protected Date createdDate;

	@Column(name = "updated_date")
	protected Date updatedDate;

	@Column(name = "created_by")
	protected Integer createdBy;

	@Column(name = "updated_by")
	protected Integer updatedBy;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationPlatform() {
		return applicationPlatform;
	}

	public void setApplicationPlatform(String applicationPlatform) {
		this.applicationPlatform = applicationPlatform;
	}

	public String getApplicationPackageName() {
		return applicationPackageName;
	}

	public void setApplicationPackageName(String applicationPackageName) {
		this.applicationPackageName = applicationPackageName;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
