package com.rainasmoon.onepay.vo;

import java.util.Date;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProductVo {

	@Size(max = 100, message = "{error.too.lang}")
	protected String productName;

	@Size(max = 20, message = "{error.too.lang}")
	protected String saleModel;

	private Date dateFrom;

	private Date dateTo;

	private Integer price;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSaleModel() {
		return saleModel;
	}

	public void setSaleModel(String saleModel) {
		this.saleModel = saleModel;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
