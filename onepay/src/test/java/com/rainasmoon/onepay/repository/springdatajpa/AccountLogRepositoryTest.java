package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rainasmoon.onepay.model.AccountLog;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("mysql")
public class AccountLogRepositoryTest {
	Logger LOGGER = LoggerFactory.getLogger(AccountLogRepositoryTest.class);

	@Autowired
	protected AccountLogRepository repository;

	@Test
	public void testSave() {
		AccountLog accountLog = new AccountLog();
		accountLog.setUserId(1L);
		accountLog.setChangeAmount(1);
		accountLog.setBalance(1);
		accountLog.setType(1);
		accountLog.setDescription("test description");
		repository.save(accountLog);
	}

	@Test
	public void testSaveMinux() {
		AccountLog accountLog = new AccountLog();
		accountLog.setUserId(2L);
		accountLog.setChangeAmount(-new Integer(3));
		accountLog.setBalance(new Integer(86));
		accountLog.setType(3);
		accountLog.setDescription(new String("[测]"));
		accountLog.setCreateDate(new Date());
		repository.save(accountLog);
	}

}
