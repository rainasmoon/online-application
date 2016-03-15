package com.rainasmoon.onepay.enums;

public enum SaleModels {
	FIXTIMEAUCTION(1), THREEDAYSALE(2), GUESSPRICE(3);

	private int code;

	private SaleModels(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static SaleModels valueOfStr(String model) {
		if ("fix_time".equals(model)) {
			return FIXTIMEAUCTION;
		} else if ("three_days".equals(model)) {
			return THREEDAYSALE;
		} else if ("guess_price".equals(model)) {
			return GUESSPRICE;
		}

		return null;
	}
}
