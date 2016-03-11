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

import com.rainasmoon.onepay.model.Tag;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class TagRepositoryTest {

	Logger LOGGER = LoggerFactory.getLogger(TagRepositoryTest.class);

	@Autowired
	protected TagRepository repository;

	@Test
	public void shouldFindAll() {
		Iterable<Tag> r = repository.findAll();
		assertNotNull(r);

		LOGGER.info(":WWW:" + r.toString());
	}
	
	@Test
	public void shouldFindTags() {
		Iterable<Tag> r = repository.findTags(1L, 0);
		assertNotNull(r);

		LOGGER.info(":WWW:" + r.toString());
	}
}
