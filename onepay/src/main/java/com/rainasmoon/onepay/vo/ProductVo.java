package com.rainasmoon.onepay.vo;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProductVo {

	@Size(max = 100, message = "{error.too.lang}")
	protected String productName;

	@Size(max = 20, message = "{error.too.lang}")
	protected String saleModel;

	private Integer price;

	private Integer aging;

	private String description;

	private String[] tags;

	private String error;

	public ProductVo() {
		price = 1;
	}

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAging() {
		return aging;
	}

	public void setAging(Integer aging) {
		this.aging = aging;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
