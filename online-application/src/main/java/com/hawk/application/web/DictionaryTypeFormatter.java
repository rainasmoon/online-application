package com.hawk.application.web;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;

import com.hawk.application.model.Dictionary;
import com.hawk.application.model.PlatformType;

public class DictionaryTypeFormatter implements Formatter<Dictionary> {
	Logger LOGGER = LoggerFactory.getLogger(DictionaryTypeFormatter.class);

	public String print(Dictionary dictionary, Locale locale) {
		return dictionary.getDictionaryValue();
	}

	public Dictionary parse(String text, Locale locale) throws ParseException {
		LOGGER.debug("the format text is:" + text);
		
		return new Dictionary();
	}
}
