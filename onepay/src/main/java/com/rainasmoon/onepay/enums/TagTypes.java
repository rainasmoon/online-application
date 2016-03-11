package com.rainasmoon.onepay.enums;

public enum TagTypes {
	USER(1), PRODUCT(2);
	private int code;
	private TagTypes(int code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
}
