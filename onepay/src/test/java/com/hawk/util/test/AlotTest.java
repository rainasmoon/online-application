package com.hawk.util.test;

import java.util.Random;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlotTest {

	Logger LOGGER = LoggerFactory.getLogger(AlotTest.class);

	@Test
	public void testRandom() {
		Random rand = new Random();
		LOGGER.debug("" + (rand.nextInt(100) + 20));

		LOGGER.debug("" + (rand.nextDouble()));
		LOGGER.debug("" + (rand.nextDouble()));
		LOGGER.debug("" + (rand.nextDouble()));

	}
}
