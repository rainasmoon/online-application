package com.rainasmoon.onepay.enums;

public enum OrderStatus {
	WAITINFO(1, "待确认"), DOWN(2, "下单成功"), WAITPAY(3, "待支付"), PAYED(4, "支付完成"), WAITSEND(
			5, "待发货"), SENDED(6, "已发货"), ONTHEWAY(7, "运输中"), RECEIVED(8, "已收货"), WAITBUYERSTARS(
			9, "待评价"), WAITSALERSTARS(10, "待评价"), DONE(11, "完成"), FAIL(12, "失败");

	private int code;
	private String name;

	private OrderStatus(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static OrderStatus valueOf(Integer code) {
		switch (code) {
		case 1:
			return WAITINFO;
		case 2:
			return DOWN;
		case 3:
			return WAITPAY;
		case 4:
			return PAYED;
		case 5:
			return WAITSEND;
		case 6:
			return SENDED;
		case 7:
			return ONTHEWAY;
		case 8:
			return RECEIVED;
		case 9:
			return WAITBUYERSTARS;
		case 10:
			return WAITSALERSTARS;
		case 11:
			return DONE;
		case 12:
			return FAIL;

		}
		return null;
	}

	public static OperationEnum getBuyerOperation(OrderStatus orderStatus) {
		switch (orderStatus) {
		case WAITINFO:
			return OperationEnum.BUYER_FILL_INFO;
		case DOWN:
		case WAITPAY:
			return OperationEnum.BUYER_PAY;
		case PAYED:
		case WAITSEND:
			return OperationEnum.WAITING;
		case SENDED:
		case ONTHEWAY:
			return OperationEnum.BUYER_RECEIVE;
		case RECEIVED:
		case WAITBUYERSTARS:
			return OperationEnum.BUYER_STAR;
		case WAITSALERSTARS:
		case DONE:
		case FAIL:

		}
		return OperationEnum.NOTHING;
	}

	public static OperationEnum getSalerOperation(OrderStatus orderStatus) {
		switch (orderStatus) {
		case WAITINFO:
		case DOWN:
		case WAITPAY:
			return OperationEnum.WAITING;
		case PAYED:
		case WAITSEND:
			return OperationEnum.SALER_SEND;
		case SENDED:
		case ONTHEWAY:
		case RECEIVED:
		case WAITBUYERSTARS:
			return OperationEnum.WAITING;
		case WAITSALERSTARS:
			return OperationEnum.SALER_STAR;
		case DONE:
		case FAIL:

		}
		return OperationEnum.NOTHING;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
