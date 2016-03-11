package com.rainasmoon.onepay.repository.springdatajpa;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rainasmoon.onepay.model.BidLog;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class BidLogRepositoryTest {

	Logger LOGGER = LoggerFactory.getLogger(BidLogRepositoryTest.class);

	@Autowired
	protected BidLogRepository repository;

	@Test
	public void shouldFindAll() {
		Iterable<BidLog> r = repository.findAll();
		assertNotNull(r);

		LOGGER.info(":WWW:" + r.toString());
	}

	@Test
	public void shouldSave() {
		BidLog bidLog = new BidLog();
		bidLog = repository.save(bidLog);
		assertNotNull(bidLog.getId());
	}
}
