package com.rainasmoon.onepay.vo;

import com.rainasmoon.onepay.enums.OperationEnum;
import com.rainasmoon.onepay.enums.OrderStatus;
import com.rainasmoon.onepay.model.Order;

public class OrderVo extends Order {

	private String salerName;
	private String buyerName;
	private String productName;
	private OperationEnum operation;

	public OrderStatus getEnumStatus() {
		return OrderStatus.valueOf(getStatus());
	}

	public String getSalerName() {
		return salerName;
	}

	public void setSalerName(String salerName) {
		this.salerName = salerName;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public OperationEnum getOperation() {
		return operation;
	}

	public void setOperation(OperationEnum operation) {
		this.operation = operation;
	}

}
