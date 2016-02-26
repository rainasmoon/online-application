package com.hawk.application.service;

public class KeyGenerateException extends RuntimeException {

	private static final long serialVersionUID = 1674308706387006246L;

	public KeyGenerateException(String id) {
		super(id + "not found");
	}

}
