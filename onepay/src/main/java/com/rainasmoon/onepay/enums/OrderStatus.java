package com.rainasmoon.onepay.enums;

public enum OrderStatus {
	WAITINFO(1), DOWN(2), WAITPAY(3), PAYED(4), WAITSEND(5), SENDED(6), ONTHEWAY(7), RECEIVED(8), WAITSTARS(9), DONE(10), FAIL(11);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
