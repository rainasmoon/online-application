package com.rainasmoon.onepay.enums;

public enum OperationEnum {
	BUYER_FILL_INFO(1, "完善信息", "order_fill.html"), BUYER_PAY(2, "付款",
			"order_pay.html"), BUYER_RECEIVE(3, "收货", "order_receive.html"), BUYER_STAR(
			4, "评价", "order_receive_star.html"), SALER_SEND(5, "发货",
			"order_send.html"), SALER_STAR(6, "评价", "order_sale_star.html"), WAITING(
			7, "等待对方操作", ""), NOTHING(8, "无法操作", "");
	private int id;
	private String operationName;
	private String operationUrl;

	private OperationEnum(int id, String operationName, String operationUrl) {
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
