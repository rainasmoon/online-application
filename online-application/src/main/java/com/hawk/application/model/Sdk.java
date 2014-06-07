package com.hawk.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "sdks")
public class Sdk extends BaseEntity {

	@Column(name = "platform")
	protected String platform;
	
	@Column(name = "sdk_type")
	protected String sdkType;
	
	@Column(name = "version")
	protected String version;
	
	@Column(name = "download_path")
	protected String downloadPath;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getSdkType() {
		return sdkType;
	}

	public void setSdkType(String sdkType) {
		this.sdkType = sdkType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
}
