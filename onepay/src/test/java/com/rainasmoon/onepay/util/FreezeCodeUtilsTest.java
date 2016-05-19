package com.rainasmoon.onepay.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

		String content = EncodeUtils.decrypt("05WJrbfsa0A%3D");
		assertEquals("O_1", content);
		LOGGER.info(content);

		Map<String, String> result = EncodeUtils.decryptToMap("05WJrbfsa0A=");
		assertEquals("O", result.get("function"));
		assertEquals("1", result.get("value"));

	}

	@Test
	public void shouldFail() {
		assertEquals("O_1", EncodeUtils.decrypt("05WJrbfsa0A="));
		assertEquals("O_1", EncodeUtils.decrypt("05WJrbfsa0A=23we"));
		assertEquals("O_1", EncodeUtils.decrypt("05WJrbfsa0A=12345678"));
		assertNotNull(EncodeUtils.decrypt("05WJrbfsa0A="));
		assertNull(EncodeUtils.decrypt("05WJrbsfsa0A="));
		assertNull(EncodeUtils.decrypt("we05WJrbfsa0A=1qw"));
	}
}
