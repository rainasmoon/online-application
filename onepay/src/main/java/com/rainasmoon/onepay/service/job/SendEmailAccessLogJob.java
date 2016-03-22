package com.rainasmoon.onepay.service.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendEmailAccessLogJob {

	@Scheduled(cron = "0/5 * * * * ?")
	public void run() {
		System.out.print("fffffffffffffffffffffffffffffff");
	}
}
