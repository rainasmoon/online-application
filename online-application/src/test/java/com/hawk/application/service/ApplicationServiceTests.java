package com.hawk.application.service;

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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hawk.application.model.AppParameter;
import com.hawk.application.model.Application;
import com.hawk.application.repository.springdatajpa.AppParameterRepository;
import com.hawk.application.repository.springdatajpa.ApplicationRepository;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("spring-data-jpa")
public class ApplicationServiceTests {

	Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceTests.class);

	@Autowired
	protected ApplicationService applicationService;

	@Autowired
	protected ApplicationRepository applicationRepository;

	@Autowired
	protected AppParameterRepository appParameterRepository;

	@Test
	public void shouldSaveApplication() {

		Application application = givenAapplication();

		applicationService.saveApplication(application);

		application = applicationRepository.findOne(application.getId());

		assertNotNull(application);
		assertEquals("test", application.getApplicationName());

	}

	@Test
	public void shouldSaveParameters() {
		Application application = givenAapplication();
		applicationRepository.save(application);

		AppParameter param = new AppParameter();
		param.setApplication(application);
		param.setParamName("test");
		appParameterRepository.save(param);

		param = appParameterRepository.findOne(param.getId());

		LOGGER.debug(param.toString());

		assertNotNull(param);
		assertEquals("test", param.getParamName());

	}

	@Test
	public void shouldDeleteParam() {

		Application application = givenAapplication();
		applicationRepository.save(application);

		AppParameter param = new AppParameter();
		param.setApplication(application);
		param.setParamName("test");
		appParameterRepository.save(param);

		applicationService.deleteAppParameterById(param.getId());

		param = appParameterRepository.findOne(param.getId());

		assertNull(param);

	}

	private Application givenAapplication() {
		Application application = new Application();

		application.setApplicationName("test");
		application.setApplicationPlatform("iso");
		application.setApplicationPackageName("a.b.c");

		return application;
	}
}