package com.rainasmoon.onepay.service.job.impl;

import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailSendLog {

	public void sendAccessLog() throws EmailException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("/var/logs/onepayaccess.log");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("the access log");
		attachment.setName("onepaylog");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.rainasmoon.com");
		email.setAuthenticator(new DefaultAuthenticator("help@rainasmoon.com", "Fhwl7758"));
		email.addTo("rainasmoon@126.com", "glen");
		email.setFrom("help@rainasmoon.com", "Me");
		email.setSubject("[onepay] access log");
		email.setMsg("the access log from one pay on " + new Date());

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();

	}
}
