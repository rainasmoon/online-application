package com.hawk.application.web;

public class ImageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8066301189246258281L;

	public ImageNotFoundException(String id) {
		super(id + "not found");
	}

}
