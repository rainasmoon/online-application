package com.rainasmoon.onepay.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FreezeCodeUtilsTest {
	Logger LOGGER = LoggerFactory.getLogger(FreezeCodeUtilsTest.class);

	@Test
	public void shouldTest() {
		String freezeCode = EncodeUtils.encrypt("O", "1");
		LOGGER.info(freezeCode);

		String content = EncodeUtils.decrypt("MDVXSnJiZnNhMEE9");
		assertEquals("O_1", content);
		LOGGER.info(content);

		Map<String, String> result = EncodeUtils.decryptToMap("MDVXSnJiZnNhMEE9");
		assertEquals("O", result.get("function"));
		assertEquals("1", result.get("value"));

	}

	@Test
	public void shouldFail() {
		assertEquals("O_1", EncodeUtils.decrypt("MDVXSnJiZnNhMEE9"));
		assertEquals("O_1", EncodeUtils.decrypt("MDVXSnJiZnNhMEE990"));
		assertEquals("O_1", EncodeUtils.decrypt("MDVXSnJiZnNhMEE9"));
		assertNull(EncodeUtils.decrypt("yMDVXSnJiZnNhMEE9"));

	}

	// Test some basic encode & decode function.
	@Test
	public void decodeTest() throws UnsupportedEncodingException {
		LOGGER.info(java.net.URLDecoder.decode("cINrBm+8UbQ=", CommonConstants.UTF_8));

		String r = Base64.getEncoder().encodeToString("cINrBm+8UbQ=".getBytes(CommonConstants.UTF_8));
		LOGGER.info(r);

		LOGGER.info(new String(Base64.getDecoder().decode("Y0lOckJtKzhVYlE9"), CommonConstants.UTF_8));
	}
}
