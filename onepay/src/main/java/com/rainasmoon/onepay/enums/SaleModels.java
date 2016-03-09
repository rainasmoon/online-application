package com.rainasmoon.onepay.enums;

public enum SaleModels {
	FIXTIMEAUCTION(1), THREEDAYSALE(2), GUESSPRICE(3);

	private int code;

	private SaleModels(int code) {
		this.code = code;
	}
}
