package com.rainasmoon.onepay.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BidServiceTest extends BaseTest {

	Logger LOGGER = LoggerFactory.getLogger(BidServiceTest.class);

	@Autowired
	protected BidService service;

	@Test
	public void shouldBid() {
		String p = service.bidAddMoney(1L, 1L, 10);
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
