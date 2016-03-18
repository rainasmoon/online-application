package com.rainasmoon.onepay.enums;

public enum ProductStatus {
	ONSALE(1), DEAL(2), FAIL(3), DONE(4);

	private int code;

	private ProductStatus(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
