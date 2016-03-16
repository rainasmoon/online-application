package com.rainasmoon.onepay.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTest {

	Logger LOGGER = LoggerFactory.getLogger(FileTest.class);

	@Test
	public void test() {
		String f = FileTest.class.getResource("testpic").getFile();
		LOGGER.info("WWW:" + f);
		assertNotNull(f);
	}
}
