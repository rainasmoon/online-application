package com.hawk.application.web;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.hawk.application.model.PlatformType;

public class PlatformTypeFormatter implements Formatter<PlatformType> {

	public String print(PlatformType platformType, Locale locale) {
		return platformType.getName();
	}

	public PlatformType parse(String text, Locale locale) throws ParseException {
		List<PlatformType> findPlatformTypes = PlatformType
				.getAllPlatformTypes();
		for (PlatformType type : findPlatformTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}
}
