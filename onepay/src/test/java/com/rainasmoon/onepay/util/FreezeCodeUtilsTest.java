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
		String freezeCode = FreezeCodeUtils.encrypt("O", "1");
		LOGGER.info(freezeCode);

		String content = FreezeCodeUtils.decrypt("05WJrbfsa0A=");
		assertEquals("O_1", content);
		LOGGER.info(content);

		Map<String, String> result = FreezeCodeUtils
				.decryptToMap("05WJrbfsa0A=");
		assertEquals("O", result.get("function"));
		assertEquals("1", result.get("value"));

	}

	@Test
	public void shouldFail() {
		assertEquals("O_1", FreezeCodeUtils.decrypt("05WJrbfsa0A="));
		assertEquals("O_1", FreezeCodeUtils.decrypt("05WJrbfsa0A=23we"));
		assertEquals("O_1", FreezeCodeUtils.decrypt("05WJrbfsa0A=12345678"));
		assertNotNull(FreezeCodeUtils.decrypt("05WJrbfsa0A="));
		assertNull(FreezeCodeUtils.decrypt("05WJrbsfsa0A="));
		assertNull(FreezeCodeUtils.decrypt("we05WJrbfsa0A=1qw"));
	}
}
