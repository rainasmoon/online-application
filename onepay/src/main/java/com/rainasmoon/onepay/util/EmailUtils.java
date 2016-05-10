package com.rainasmoon.onepay.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtils {

	public static Logger LOGGER = LoggerFactory.getLogger(EmailUtils.class);

	private static Email email = new SimpleEmail();

	static {
		email.setHostName("smtp.rainasmoon.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("help@rainasmoon.com", "Fhwl7758"));
		email.setSSLOnConnect(false);

	}

	public static void sendEmail(String title, String content, String to) {
		try {
			privateSendEmail(title, content, to);
		} catch (EmailException e) {
			LOGGER.error("sendEmail Exception.", e);
			e.printStackTrace();
		}
	}

	private static void privateSendEmail(String title, String content, String to) throws EmailException {

		email.setFrom("help@rainasmoon.com");

		email.setSubject(title);
		email.setMsg(content);
		email.addTo(to);
		email.send();
	}
}
