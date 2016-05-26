package com.rainasmoon.onepay.util;

import org.junit.Test;

public class MessageTest {

	@Test
	public void testSend() {
		// new MessageUtils().send("15811015803", "Glen", "testCode");

		new MessageUtils().send("13691300925", "Glen", "testCode");
	}

	@Test
	public void testSendNotice() {
		// new MessageUtils().send("15811015803", "Glen", "testCode");

		new MessageUtils().sendNotice("13691300925", "Gold", "testStatus");
	}

}
