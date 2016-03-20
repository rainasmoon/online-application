package com.rainasmoon.onepay.enums;

public enum YunModels {
	BUY(1, "买"), SALE(2, "卖");

	private int code;
	private String name;

	private YunModels(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static YunModels valueOf(Integer code) {
		if (code == null) {
			return null;
		}
		switch (code) {
		case 1:
			return BUY;
		case 2:
			return SALE;

		}
		return null;
	}
}
