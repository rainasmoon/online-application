package com.hawk.application.prepare;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

public class PrepareRadisTest {

	Logger LOGGER = LoggerFactory.getLogger(PrepareRadisTest.class);

	@Test
	public void test() {
		Jedis jedis = new Jedis("localhost");
		String index = jedis.select(0);
		LOGGER.debug("index" + index);
		jedis.set("foo", "bar1");
		String value = jedis.get("foo");
		LOGGER.debug("test:" + value);

		jedis.set("b984a862-c66f-47b3-bf38-fdccfaf2192f_20140619_total_user",
				"150");
		jedis.set("b984a862-c66f-47b3-bf38-fdccfaf2192f_20140618_total_user",
				"50");
		jedis.set(
				"b984a862-c66f-47b3-bf38-fdccfaf2192f_20140618_total_promotion",
				"120");
		jedis.set("b984a862-c66f-47b3-bf38-fdccfaf2192f_20140618_total_user",
				"100");
		jedis.set("b984a862-c66f-47b3-bf38-fdccfaf2192f_20140519_total_user",
				"20");
		jedis.set("b984a862-c66f-47b3-bf38-fdccfaf2192f_20140520_total_user",
				"22");
		jedis.set("b984a862-c66f-47b3-bf38-fdccfaf2192f_20140521_total_user",
				"30");
		jedis.set("b984a862-c66f-47b3-bf38-fdccfaf2192f_20140522_total_user",
				"32");
		jedis.set("b984a862-c66f-47b3-bf38-fdccfaf2192f_20140523_total_user",
				"19");
		jedis.set("b984a862-c66f-47b3-bf38-fdccfaf2192f_20140524_total_user",
				"20");
		jedis.set(
				"b984a862-c66f-47b3-bf38-fdccfaf2192f_20140519_total_promotion",
				"105");
	}

}
