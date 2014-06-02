package com.hawk.util.test;

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
}
