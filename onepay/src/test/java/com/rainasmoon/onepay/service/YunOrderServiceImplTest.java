package com.rainasmoon.onepay.service;

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

import com.rainasmoon.onepay.model.YunOrder;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@Rollback(true)
@Transactional
@Sql(value = { "classpath:insert-test-data.sql" }, config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--", dataSource = "dataSource", transactionManager = "transactionManager"))
public class YunOrderServiceImplTest {

	Logger LOGGER = LoggerFactory.getLogger(YunOrderServiceImplTest.class);

	@Autowired
	protected YunOrderService service;

	@Test
	public void shouldTestLogger() {
		LOGGER.info("hi... log.");
	}

	@Test
	public void shouldBid() {
		YunOrder yunOrder = new YunOrder();
		YunOrder p = service.save(yunOrder);
		assertNotNull(p);

	}

}
