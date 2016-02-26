package com.rainasmoon.util.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTest {

	Logger LOGGER = LoggerFactory.getLogger(DateTest.class);

	@Test
	public void test() {
		LOGGER.debug(new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}
	
	@Test
	public void testTodayAndYesterday() {
		LOGGER.debug(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()));
		LOGGER.debug(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date(new Date().getTime() - 24*60*60*1000)));
	}
}
