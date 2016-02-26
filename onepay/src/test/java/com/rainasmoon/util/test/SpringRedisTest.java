package com.rainasmoon.util.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class SpringRedisTest {

	Logger LOGGER = LoggerFactory.getLogger(SpringRedisTest.class);

	// inject the actual template
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	// inject the template as ListOperations
	// can also inject as Value, Set, ZSet, and HashOperations
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valueOps;

	@Test
	public void addLink() {
		listOps.leftPush("l-test-1", "l element");
		// or use template directly
		redisTemplate.boundListOps("l-test-2").leftPush("l element2");
	}

	@Test
	public void getValue() {
		valueOps.get("me");
	}

	@Test
	public void setValue() {
		valueOps.set("foo2", "i am you");

	}
}
