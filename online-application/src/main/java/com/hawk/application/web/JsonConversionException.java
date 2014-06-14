package com.hawk.application.web;

public class JsonConversionException extends Exception {

	private static final long serialVersionUID = 6701481509005549217L;
	private int errorCode = 0;

	public JsonConversionException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public JsonConversionException(String message) {
		super(message);
	}

	public JsonConversionException() {
		super();
	}

	public JsonConversionException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public JsonConversionException(String message, int errorCode,
			Throwable throwable) {
		super(message, throwable);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
