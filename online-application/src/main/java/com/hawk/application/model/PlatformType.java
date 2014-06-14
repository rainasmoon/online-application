package com.hawk.application.model;

import java.util.Arrays;
import java.util.List;

public class PlatformType {

	private static List<PlatformType> platformTypes;
	private String name;

	public static List<PlatformType> getAllPlatformTypes() {
		if (platformTypes == null) {
			platformTypes = Arrays.asList(new PlatformType("iso"));
		}
		return platformTypes;
	}

	public PlatformType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
