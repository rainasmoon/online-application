package com.hawk.mgc.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SearchMgcPackageVo {

	private MgcPackage mgcPackage;
	private String mgcProduct;
	private Date dateFrom;
	private Date dateTo;

	public SearchMgcPackageVo() {

	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);

	}

	public static class Builder {
		private MgcPackage mgcPackage;
		private String mgcProduct;
		private Date dateFrom;
		private Date dateTo;

		public Builder mgcPackage(MgcPackage mgcPackage) {
			this.mgcPackage = mgcPackage;
			return this;
		}

		public Builder mgcProduct(String mgcProduct) {
			this.mgcProduct = mgcProduct;
			return this;
		}

		public Builder dateFrom(Date dateFrom) {
			this.dateFrom = dateFrom;
			return this;
		}

		public Builder dateTo(Date dateTo) {
			this.dateTo = dateTo;
			return this;
		}

		public SearchMgcPackageVo build() {
			return new SearchMgcPackageVo(this);
		}
	}

	private SearchMgcPackageVo(Builder builder) {
		this.mgcPackage = builder.mgcPackage;
		this.mgcProduct = builder.mgcProduct;
		this.dateFrom = builder.dateFrom;
		this.dateTo = builder.dateTo;
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
