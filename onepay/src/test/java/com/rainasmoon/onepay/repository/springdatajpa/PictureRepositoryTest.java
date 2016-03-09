package com.rainasmoon.onepay.repository.springdatajpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

import com.rainasmoon.onepay.model.Picture;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@Rollback(true)
@Transactional
@Sql(value = { "classpath:insert-test-data.sql" }, config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--", dataSource = "dataSource", transactionManager = "transactionManager") )

public class PictureRepositoryTest {

	Logger LOGGER = LoggerFactory.getLogger(PictureRepositoryTest.class);

	@Autowired
	protected PictureRepository repository;

	@Test
	public void shouldFindAll() {
		Iterable<Picture> r = repository.findAll();
		assertNotNull(r);

		LOGGER.info(":WWW:" + r.toString());
	}

	@Test
	public void shouldSaveUser() {
		Picture u = new Picture();

		Picture r = repository.save(u);
		assertNotNull(r.getId());
	}

	@Test
	public void shouldFindPictures() {
		Long productId = 1L;
		List<Picture> pics = repository.findPictures(productId);

		assertNotNull(pics);
		assertTrue(pics.size() > 0);
	}
}
