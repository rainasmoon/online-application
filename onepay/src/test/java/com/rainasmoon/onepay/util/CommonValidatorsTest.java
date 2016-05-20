package com.rainasmoon.onepay.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommonValidatorsTest {

	@Test
	public void test() {
		assertTrue(CommonValidators.isMobile("15810011003"));
		assertTrue(CommonValidators.isMobile("15000000000"));

		assertFalse(CommonValidators.isMobile("00000000000"));
		assertFalse(CommonValidators.isMobile("11810011003"));
		assertFalse(CommonValidators.isMobile("1581001100"));
	}
}
