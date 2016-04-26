package com.rainasmoon.onepay.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

public class EmailTest {

	@Test
	public void shouldSendEmail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.rainasmoon.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("help@rainasmoon.com", "Fhwl7758"));
		email.setSSLOnConnect(false);
		email.setFrom("help@rainasmoon.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("rainasmoon@126.com");
		email.send();

	}

	@Test
	public void shouldSendEmailWithAttachment() throws EmailException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(EmailTest.class.getResource("test.log").getFile());
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of John");
		attachment.setName("John");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.rainasmoon.com");
		email.setAuthenticator(new DefaultAuthenticator("help@rainasmoon.com", "Fhwl7758"));
		email.addTo("rainasmoon@126.com", "John Doe");
		email.setFrom("help@rainasmoon.com", "Me");
		email.setSubject("The picture");
		email.setMsg("Here is the picture you wanted");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();

	}
}