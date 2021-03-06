package com.hawk.mgc.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "package_details")
public class MgcPackageDetail extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "package_id")
	protected MgcPackage mgcPackage;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "detail_date")
	@NotNull(message = "{not.null}")
	protected Date detailDate;

	@Column(name = "installations")
	@NotNull(message = "{not.null}")
	protected Integer installations;

	@Column(name = "activations")
	@NotNull(message = "{not.null}")
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

	public String toShortString() {
		String dateString = detailDate == null ? null : new SimpleDateFormat(
				"yyyy-MM-dd").format(detailDate);
		String shortString = "[日期：" + dateString + "； 安装量：" + installations
				+ "； 激活量：" + activations + "]";
		return shortString;
	}

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

	public Date getDetailDate() {
		return detailDate;
	}

	public void setDetailDate(Date detailDate) {
		this.detailDate = detailDate;
	}
}
