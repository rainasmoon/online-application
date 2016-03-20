package com.rainasmoon.onepay.enums;

public enum YunStatus {
	WAITINFO(1, "待确认"), DOWN(2, "交易中"), WAIT(3, "待交易"), TRADED(4, "交易完成"), WAITVERIFY(
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
			return WAIT;
		case 4:
			return TRADED;
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

	public static YunOperationEnum getUserPutOperation(YunStatus status) {
		switch (status) {
		case WAITINFO:
			return YunOperationEnum.WAITINGTRADE;
		case DOWN:
		case WAIT:
		case TRADED:
			return YunOperationEnum.VIEW_VERIFY_CODE;
		case WAITVERIFY:
		case VERIFYED:
		case DONE:
		case FAIL:

		}
		return YunOperationEnum.NOTHING;
	}

	public static YunOperationEnum getDealerPutOperation(YunStatus status) {
		switch (status) {
		case WAITINFO:
			return YunOperationEnum.WAITINGTRADE;
		case DOWN:
		case WAIT:
			return YunOperationEnum.BUY;
		case TRADED:
		case WAITVERIFY:
			return YunOperationEnum.INPUT_VERIFY_CODE;
		case VERIFYED:
		case DONE:
		case FAIL:

		}
		return YunOperationEnum.NOTHING;
	}

	public static YunOperationEnum getOtherPutOperation(YunStatus status) {
		switch (status) {
		case WAITINFO:
			return YunOperationEnum.WAITINGTRADE;
		case DOWN:
		case WAIT:
			return YunOperationEnum.BUY;
		case TRADED:
		case WAITVERIFY:
		case VERIFYED:
		case DONE:
		case FAIL:

		}
		return YunOperationEnum.NOTHING;
	}

	public static YunOperationEnum getUserCallOperation(YunStatus status) {
		switch (status) {
		case WAITINFO:
			return YunOperationEnum.WAITINGTRADE;
		case DOWN:
		case WAIT:
		case TRADED:
		case WAITVERIFY:
			return YunOperationEnum.INPUT_VERIFY_CODE;
		case VERIFYED:
		case DONE:
		case FAIL:

		}
		return YunOperationEnum.NOTHING;
	}

	public static YunOperationEnum getDealerCallOperation(YunStatus status) {
		switch (status) {
		case WAITINFO:
			return YunOperationEnum.WAITINGTRADE;
		case DOWN:
		case WAIT:
			return YunOperationEnum.SALE;
		case TRADED:
			return YunOperationEnum.VIEW_VERIFY_CODE;
		case WAITVERIFY:
		case VERIFYED:
		case DONE:
		case FAIL:

		}
		return YunOperationEnum.NOTHING;
	}

	public static YunOperationEnum getOtherCallOperation(YunStatus status) {
		switch (status) {
		case WAITINFO:
			return YunOperationEnum.WAITINGTRADE;
		case DOWN:
		case WAIT:
			return YunOperationEnum.SALE;
		case TRADED:
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
