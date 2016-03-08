package com.rainasmoon.onepay.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommonUtilsTest {

	@Test
	public void shouldTest() {
		assertTrue(CommonUtils.isEmail("Test@cc.com"));
		assertTrue(CommonUtils.isEmail("@"));
		assertTrue(CommonUtils.isEmail("12345@126"));
		assertFalse(CommonUtils.isEmail("13988884444"));
	}
}
