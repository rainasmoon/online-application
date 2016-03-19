package com.rainasmoon.onepay.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtilsTest {

	Logger LOGGER = LoggerFactory.getLogger(CommonUtilsTest.class);

	@Test
	public void shouldTest() {
		assertTrue(CommonUtils.isEmail("Test@cc.com"));
		assertTrue(CommonUtils.isEmail("@"));
		assertTrue(CommonUtils.isEmail("12345@126"));
		assertFalse(CommonUtils.isEmail("13988884444"));
	}

	@Test
	public void shouldTestDate() throws ParseException {
		DateFormat sf = new SimpleDateFormat("yyyyMMdd");
		DateFormat sfFull = new SimpleDateFormat("yyyyMMddhhmmss");
		LOGGER.info(sf.format(new Date()));
		LOGGER.info(sfFull.format(new Date()));
		LOGGER.info(sfFull.parse(sf.format(new Date()) + "000000").toString());
		LOGGER.info(sfFull.parse(sf.format(new Date()) + "235959").toString());
	}
}
