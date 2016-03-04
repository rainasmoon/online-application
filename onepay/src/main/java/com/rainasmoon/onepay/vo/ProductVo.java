package com.rainasmoon.onepay.vo;

import javax.validation.constraints.Size;

public class ProductVo extends AdVo {

	@Size(max = 100, message = "{error.too.lang}")
	protected String productName;

	@Size(max = 20, message = "{error.too.lang}")
	protected String saleType;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
}
