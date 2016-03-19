package com.rainasmoon.onepay.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.service.BidService;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@Rollback(true)
@Transactional
@Sql(value = { "classpath:insert-test-data.sql" }, config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--", dataSource = "dataSource", transactionManager = "transactionManager"))
public class BidServiceImplTest {

	Logger LOGGER = LoggerFactory.getLogger(BidServiceImplTest.class);

	@Autowired
	protected BidService service;

	@Test
	public void shouldTestLogger() {
		LOGGER.info("hi... log.");
	}

	@Test
	public void shouldBid() {
		Product p = service.bidAddMoney(1L, 1L, 10);
		assertNotNull(p);

	}

	@Test
	public void shouldGuessPrice() {
		String r = service.guessMoney(1L, 1L, 0);
		LOGGER.info("R:" + r);
		assertEquals("太低了，不卖", r);

		r = service.guessMoney(1L, 1L, 10);
		LOGGER.info("R:" + r);
		assertEquals("猜过了，明天再来试试？", r);

		r = service.guessMoney(1L, 1L, 0);
		LOGGER.info("R:" + r);
		assertEquals("猜过了，明天再来试试？", r);
	}

	@Test
	public void shouldGuessPriceWithDeal() {
		String r = service.guessMoney(1L, 1L, 100);
		LOGGER.info("R:" + r);
		assertEquals("成交了", r);

		r = service.guessMoney(1L, 1L, 10);
		LOGGER.info("R:" + r);
		assertEquals("下架了", r);

		r = service.guessMoney(1L, 1L, 0);
		LOGGER.info("R:" + r);
		assertEquals("下架了", r);
	}
}
