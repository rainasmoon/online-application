package com.rainasmoon.weixin.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeixinApiTest {

	Logger LOGGER = LoggerFactory.getLogger(WeixinApiTest.class);

	@Test
	public void testGetToken() {
		String token = WeixinApi.getAccessToken();
		assertNotNull(token);
		LOGGER.info(token);
	}

	@Test
	public void testCreateMenu() {
		WeixinApi.createWinXinMenu();

	}
}
