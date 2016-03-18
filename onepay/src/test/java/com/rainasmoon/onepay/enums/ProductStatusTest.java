package com.rainasmoon.onepay.enums;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductStatusTest {

	Logger LOGGER = LoggerFactory.getLogger(ProductStatusTest.class);

	@Test
	public void test() {
		LOGGER.info(ProductStatus.FAIL.name());
		LOGGER.info(ProductStatus.valueOf("FAIL").name());

	}
}
