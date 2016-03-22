package com.rainasmoon.onepay.service.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendEmailAccessLogJob {
	public static Logger LOGGER = LoggerFactory
			.getLogger(SendEmailAccessLogJob.class);

	@Scheduled(cron = "0/5 * * * * ?")
	public void run() {
		LOGGER.info("MyFirstSpringJob trigger...");
	}
}
