package com.rainasmoon.onepay.repository.springdatajpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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

	@Test
	public void shouldFindBidLog() {
		List<BidLog> r = repository.findByProductIdOrderByCreateDateDesc(1L);
		assertNotNull(r);
		assertEquals(0, r.size());

		BidLog bidLog = new BidLog();
		bidLog.setProductId(1L);
		bidLog.setPrice(1);
		repository.save(bidLog);

		r = repository.findByProductIdOrderByCreateDateDesc(1L);
		assertEquals(1, r.size());

		bidLog = new BidLog();
		bidLog.setProductId(1L);
		bidLog.setPrice(2);
		repository.save(bidLog);

		r = repository.findByProductIdOrderByCreateDateDesc(1L);
		assertEquals(2, r.size());
		assertEquals(new Integer(2), r.get(0).getPrice());

	}
}
