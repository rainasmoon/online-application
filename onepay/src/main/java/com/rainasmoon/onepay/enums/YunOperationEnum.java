package com.rainasmoon.onepay.enums;

public enum YunOperationEnum {
	BUY(1, "买", "market_buy.html"), SALE(2, "卖", "market_sell.html"), WAITINGTRADE(
			3, "等待", ""), VIEW_VERIFY_CODE(4, "查看", "market_view_trade.html"), INPUT_VERIFY_CODE(
			5, "解冻", "market_unfreeze.html"), NOTHING(6, "无法操作", "");
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
