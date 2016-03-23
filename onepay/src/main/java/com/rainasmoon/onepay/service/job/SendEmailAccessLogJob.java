package com.rainasmoon.onepay.service.job;

import org.apache.commons.mail.EmailException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rainasmoon.onepay.service.job.impl.EmailSendLog;

@Component
public class SendEmailAccessLogJob {

	@Scheduled(cron = "0 0 23 * * ?")
	public void run() {
		printLog("发送邮件开始——");
		try {
			new EmailSendLog().sendAccessLog();
		} catch (EmailException e) {
			printLog("Error:" + e);
		}
		printLog("发送邮件结束】】】");
	}

	private void printLog(String message) {
		System.out.println(message);
	}
}
