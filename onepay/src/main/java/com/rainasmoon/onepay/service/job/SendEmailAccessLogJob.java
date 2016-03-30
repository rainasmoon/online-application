package com.rainasmoon.onepay.service.job;

import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rainasmoon.onepay.service.BidService;
import com.rainasmoon.onepay.service.job.impl.EmailSendLog;

@Component
public class SendEmailAccessLogJob {

	public static Logger LOGGER = LoggerFactory.getLogger(SendEmailAccessLogJob.class);

	@Autowired
	private BidService bidService;

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

	@Scheduled(cron = "0 0 0 * * ?")
	public void runScheduledGenerateOrders() {
		printLog("自动生成Order开始——");
		bidService.generateBidThreeDays();

		bidService.generateBidThreeTimes();
		printLog("自动生成Order结束】】】");
	}

	private void printLog(String message) {
		LOGGER.info(message);
		System.out.println(message);
	}
}
