package com.hawk.mgc.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SearchMgcPackageVo {

	private MgcPackage mgcPackage;
	private String mgcProduct;
	private Date dateFrom;
	private Date dateTo;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);

	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public boolean isSelectedAllPackage() {

		return mgcPackage == null || mgcPackage.getId() == null;
	}

	public MgcPackage getMgcPackage() {
		return mgcPackage;
	}

	public void setMgcPackage(MgcPackage mgcPackage) {
		this.mgcPackage = mgcPackage;
	}

	public String getMgcProduct() {
		return mgcProduct;
	}

	public void setMgcProduct(String mgcProduct) {
		this.mgcProduct = mgcProduct;
	}

}
