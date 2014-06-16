package com.hawk.application.repository.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class RedisRepositoryImplTest {

	Logger LOGGER = LoggerFactory.getLogger(RedisRepositoryImplTest.class);

	@Autowired
	private RedisRepository redisRepository;

	@Test
	public void testSaveData() {
		redisRepository.setValue("me", "test");

		LOGGER.debug("the me is:" + redisRepository.getValue("me"));
	}

}
