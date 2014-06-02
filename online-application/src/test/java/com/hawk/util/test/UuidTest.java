package com.hawk.util.test;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UuidTest {

	Logger LOGGER = LoggerFactory.getLogger(UuidTest.class);

	@Test
	public void test() {
		UUID s = UUID.randomUUID();
		LOGGER.debug(s.toString());

		LOGGER.debug("" + s.toString().length());
	}
}
