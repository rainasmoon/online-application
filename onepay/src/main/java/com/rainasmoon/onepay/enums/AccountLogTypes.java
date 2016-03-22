package com.rainasmoon.onepay.enums;

public enum AccountLogTypes {

	REGISTER_REWARD(1, ""), BUY_PRODUCT(2, ""), TRANSFER_TO_USER(3, ""), TRASNSFER_TO_MARKET(4, ""), RECEIVE_FROM_MARKET(5, ""), ADD_PRODUCT_REWARD(6, "");

	private int code;
	private String name;

	private AccountLogTypes(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public AccountLogTypes valueOf(Integer code) {

		switch (code) {
		case 1:
			return REGISTER_REWARD;
		case 2:
			return BUY_PRODUCT;
		case 3:
			return TRANSFER_TO_USER;
		case 4:
			return TRASNSFER_TO_MARKET;
		case 5:
			return RECEIVE_FROM_MARKET;
		case 6:
			return ADD_PRODUCT_REWARD;
		}

		return null;
	}
}
