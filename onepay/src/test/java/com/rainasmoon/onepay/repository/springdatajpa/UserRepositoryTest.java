package com.rainasmoon.onepay.repository.springdatajpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rainasmoon.onepay.model.User;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")

@Transactional
@Sql(value = { "classpath:insert-test-data.sql" }, config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--", dataSource = "dataSource", transactionManager = "transactionManager") )

public class UserRepositoryTest {

	Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);

	@Autowired
	protected UserRepository repository;

	@Test
	public void shouldFindAll() {
		Iterable<User> r = repository.findAll();
		assertNotNull(r);

		LOGGER.info(":WWW:" + r.toString());
	}

	@Test
	public void shouldFindUser() {
		User r = repository.findByEmailOrPhone("test@test.cn");
		assertNotNull(r);
		assertEquals("funnyMe", r.getNickName());

	}

	@Test
	public void shouldFindUserByPhone() {
		User r = repository.findByEmailOrPhone("13912345555");
		assertNotNull(r);
		assertEquals("funnyMe", r.getNickName());

	}

	@Test
	public void shouldFindUserIsNull() {
		User r = repository.findByEmailOrPhone("13912341234");
		assertNull(r);

	}

	@Test
	public void shouldSaveUser() {
		User u = new User();

		User r = repository.save(u);
		assertNotNull(r.getId());
	}
}
