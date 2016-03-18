package com.rainasmoon.onepay.enums;

public enum SaleModels {
	NORMALAUCTION(1, "一元拍"), THREEDAYSALE(2, "3天拍"), GUESSPRICE(3, "猜价拍");

	private int code;
	private String name;

	private SaleModels(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {

		return name;
	}

	public static SaleModels valueOfStr(String model) {
		if ("three_times".equals(model)) {
			return NORMALAUCTION;
		} else if ("three_days".equals(model)) {
			return THREEDAYSALE;
		} else if ("guess_price".equals(model)) {
			return GUESSPRICE;
		}

		return null;
	}

	public static SaleModels valueOf(Integer model) {
		if (model == 1) {
			return NORMALAUCTION;
		} else if (model == 2) {
			return THREEDAYSALE;
		} else if (model == 3) {
			return GUESSPRICE;
		}

		return null;
	}
}
