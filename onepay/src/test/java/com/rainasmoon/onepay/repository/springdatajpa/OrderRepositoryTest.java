package com.rainasmoon.onepay.repository.springdatajpa;

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

import com.rainasmoon.onepay.model.Order;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class OrderRepositoryTest {

	Logger LOGGER = LoggerFactory.getLogger(OrderRepositoryTest.class);

	@Autowired
	protected OrderRepository repository;

	@Test
	public void shouldFindAll() {
		Iterable<Order> r = repository.findAll();
		assertNotNull(r);

		LOGGER.info(":WWW:" + r.toString());
	}

	@Test
	public void shouldFindBuyerIdOrSalerId() {
		List<Order> r = repository.findBySalerIdOrBuyerId(1L);
		assertNotNull(r);

		LOGGER.info(":WWW:" + r.toString());
	}

	@Test
	public void shouldSave() {
		Order order = new Order();
		order = repository.save(order);
		assertNotNull(order.getId());
	}
}