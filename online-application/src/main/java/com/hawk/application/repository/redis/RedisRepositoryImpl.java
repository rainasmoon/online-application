package com.hawk.application.repository.redis;

import java.net.URL;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepositoryImpl implements RedisRepository {

	// inject the actual template
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	// inject the template as ListOperations
	// can also inject as Value, Set, ZSet, and HashOperations
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valueOps;

	public void addLink(String userId, URL url) {
		listOps.leftPush(userId, url.toExternalForm());
		// or use template directly
		redisTemplate.boundListOps(userId).leftPush(url.toExternalForm());
	}

	public String getValue(String id) {
		return valueOps.get(id);
	}

	public Double getValueAsDouble(String id) {
		String value = valueOps.get(id);
		if (value == null) {
			return null;
		}
		return Double.parseDouble(value);
	}

	public Integer getValueAsInteger(String id) {
		String value = valueOps.get(id);
		if (value == null) {
			return null;
		}
		return Integer.parseInt(value);
	}

	public void setValue(String id, String value) {
		valueOps.set(id, value);

	}
}
