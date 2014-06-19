package com.hawk.application.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DayBuilderTest {

	Logger LOGGER = LoggerFactory.getLogger(DayBuilderTest.class);

	@Test
	public void test() {
		DayBuilder db = new DayBuilder();
		LOGGER.info(db.getToday().toString());
		LOGGER.info(db.getYesterday().toString());
		LOGGER.info(db.getLastMonthToday().toString());
	}
}
