package com.hawk.application.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hawk.application.model.Application;
import com.hawk.application.repository.springdatajpa.ApplicationRepository;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("spring-data-jpa")
public class ApplicationServiceTests {

	@Autowired
	protected ApplicationService applicationService;

	@Autowired
	protected ApplicationRepository applicationRepository;

	@Test
	public void shouldSaveApplication() {

		Application application = new Application();

		application.setApplicationName("test");
		application.setApplicationPlatform("iso");
		application.setApplicationPackageName("a.b.c");

		applicationService.saveApplication(application);

		application = applicationRepository.findOne(application.getId());

		assertNotNull(application);
		assertEquals("test", application.getApplicationName());

	}
}