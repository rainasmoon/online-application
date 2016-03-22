package com.rainasmoon.onepay.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainasmoon.onepay.model.YunOrder;

public class YunOrderServiceTest extends BaseTest {

	Logger LOGGER = LoggerFactory.getLogger(YunOrderServiceTest.class);

	@Autowired
	protected YunOrderService service;

	@Test
	public void shouldTestLogger() {
		LOGGER.info("hi... log.");
	}

	@Test
	public void shouldBid() {
		YunOrder yunOrder = new YunOrder();
		String p = service.addYunOrder(yunOrder);
		assertNotNull(p);

	}

}
