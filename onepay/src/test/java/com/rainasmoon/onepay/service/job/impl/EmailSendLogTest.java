package com.rainasmoon.onepay.service.job.impl;

import org.junit.Test;

public class EmailSendLogTest {

	@Test
	public void test() {

		try {
			EmailSendLog esl = new EmailSendLog();
			esl.sendAccessLog();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
