package com.rainasmoon.onepay.repository.springdatajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class AppParameterRepositoryTest {

	@Autowired
	protected AppParameterRepository appParameterRepository;

	@Test
	public void shouldFindByCreatedBy() {
		appParameterRepository.findByCreatedBy(0);
	}
}
