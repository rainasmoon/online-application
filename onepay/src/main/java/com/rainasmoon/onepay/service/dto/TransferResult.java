package com.rainasmoon.onepay.service.dto;

public class TransferResult {

	private boolean success;
	private String message;

	private TransferResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean isFail() {
		return !success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public static TransferResult fail(String message) {
		return new TransferResult(false, message);
	}

	public static TransferResult success(String message) {
		return new TransferResult(true, message);
	}

}
