package com.rainasmoon.onepay.vo;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AddYunOrderVo {

	private Integer amount;
	private Integer price;
	private String tradeModel;

	@Size(max = 600, message = "{error.too.lang}")
	private String description;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);

	}

	private String error;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTradeModel() {
		return tradeModel;
	}

	public void setTradeModel(String tradeModel) {
		this.tradeModel = tradeModel;
	}
}
