package com.rainasmoon.onepay.enums;

public enum OrderStatus {
	WAITPAY(1), WAITSEND(2), DONE(3), FAIL(4);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
