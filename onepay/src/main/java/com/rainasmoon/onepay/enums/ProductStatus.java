package com.rainasmoon.onepay.enums;

public enum ProductStatus {
	ONSALE(1, "出售中"), DEAL(2, "已成交"), FAIL(3, "失败"), DONE(4, "完成");

	private int code;
	private String name;

	private ProductStatus(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static ProductStatus valueOf(Integer code) {
		switch (code) {
		case 1:
			return ONSALE;
		case 2:
			return DEAL;
		case 3:
			return FAIL;
		case 4:
			return DONE;
		}
		return null;
	}
}
