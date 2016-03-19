package com.rainasmoon.onepay.enums;

public enum YunOperationEnum {
	BUY(1, "买", ""), SALE(2, "卖", "");
	private int id;
	private String operationName;
	private String operationUrl;

	private YunOperationEnum(int id, String operationName, String operationUrl) {
		this.id = id;
		this.operationName = operationName;
		this.operationUrl = operationUrl;
	}

	public int getId() {
		return id;
	}

	public String getOperationName() {
		return operationName;
	}

	public String getOperationUrl() {
		return operationUrl;
	}
}
