package com.rainasmoon.onepay.enums;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderStatusTest {

	Logger LOGGER = LoggerFactory.getLogger(OrderStatusTest.class);

	@Test
	public void test() {
		LOGGER.info(OrderStatus.FAIL.name());
		LOGGER.info(OrderStatus.valueOf("FAIL").name());
		LOGGER.info(OrderStatus.valueOf(1).name());
		LOGGER.info(OrderStatus.valueOf(1).getName());
	}
}
