package com.rainasmoon.onepay.repository.springdatajpa;

import static org.junit.Assert.assertNotNull;

import java.util.List;

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

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@Rollback(true)
@Transactional
@Sql(value = { "classpath:insert-test-data.sql" }, config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--", dataSource = "dataSource", transactionManager = "transactionManager"))
public class ProductRepositoryTest {

	Logger LOGGER = LoggerFactory.getLogger(ProductRepositoryTest.class);

	@Autowired
	protected ProductRepository repository;

	@Test
	public void shouldFindAll() {
		Iterable<Product> r = repository.findAll();
		assertNotNull(r);

		LOGGER.info(":WWW:" + r.toString());
	}

	@Test
	public void shouldSaveProduct() {
		Product u = new Product();

		Product r = repository.save(u);
		assertNotNull(r.getId());
	}

	@Test
	public void shouldFindMySales() {
		List<Product> r = repository.findByOwnerId(1L);

		assertNotNull(r);
	}

	@Test
	public void shouldFindByStatus() {
		List<Product> r = repository.findByStatus(1);

		assertNotNull(r);
	}
}
