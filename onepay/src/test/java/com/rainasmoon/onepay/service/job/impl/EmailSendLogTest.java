package com.rainasmoon.onepay.service.job.impl;

import org.apache.commons.mail.EmailException;
import org.junit.Test;

public class EmailSendLogTest {

	@Test
	public void test() throws EmailException {
		EmailSendLog esl = new EmailSendLog();
		esl.sendAccessLog();
	}
}
