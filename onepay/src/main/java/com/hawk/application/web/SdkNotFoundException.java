package com.hawk.application.web;

public class SdkNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9193172604619965364L;

	public SdkNotFoundException(String sdkId) {
		super(sdkId + "not found");
	}

}
