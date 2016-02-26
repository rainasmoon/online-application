package com.hawk.util.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class RadisTest {

	Logger LOGGER = LoggerFactory.getLogger(RadisTest.class);

	@Test
	public void test() {
		Jedis jedis = new Jedis("localhost");
		String index = jedis.select(1);
		LOGGER.debug("index" + index);
		jedis.set("foo", "bar1");
		String value = jedis.get("foo");

		LOGGER.debug("test:" + value);

		jedis.close();
	}

	@Test
	@Ignore
	public void testCluster() {

		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		// Jedis Cluster will attempt to discover cluster nodes automatically
		jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7379));
		JedisCluster jc = new JedisCluster(jedisClusterNodes);
		jc.set("foo", "bar");
		String value = jc.get("foo");
	}

	@Test
	public void testNothing() {

	}

}
