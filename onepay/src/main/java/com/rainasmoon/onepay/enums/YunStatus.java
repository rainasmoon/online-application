package com.rainasmoon.onepay.enums;

public enum YunStatus {
	WAITINFO(1, "待确认"), DOWN(2, "在交易"), WAITPAY(3, "待支付"), PAYED(4, "支付完成"), WAITVERIFY(
			5, "待解冻"), VERIFYED(6, "已解冻"), DONE(7, "完成"), FAIL(8, "失败");

	private int code;
	private String name;

	private YunStatus(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static YunStatus valueOf(Integer code) {
		switch (code) {
		case 1:
			return WAITINFO;
		case 2:
			return DOWN;
		case 3:
			return WAITPAY;
		case 4:
			return PAYED;
		case 5:
			return WAITVERIFY;
		case 6:
			return VERIFYED;
		case 7:
			return DONE;
		case 8:
			return FAIL;

		}
		return null;
	}

	public static YunOperationEnum getPutOperation(YunStatus status) {
		switch (status) {
		case WAITINFO:
			return YunOperationEnum.WAITINGTRADE;
		case DOWN:
		case WAITPAY:
			return YunOperationEnum.BUY;
		case PAYED:
		case WAITVERIFY:
		case VERIFYED:
		case DONE:
		case FAIL:

		}
		return YunOperationEnum.NOTHING;
	}

	public static YunOperationEnum getCallOperation(YunStatus status) {
		switch (status) {
		case WAITINFO:
			return YunOperationEnum.WAITINGTRADE;
		case DOWN:
		case WAITPAY:
			return YunOperationEnum.SALE;
		case PAYED:
		case WAITVERIFY:
		case VERIFYED:
		case DONE:
		case FAIL:

		}
		return YunOperationEnum.NOTHING;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
