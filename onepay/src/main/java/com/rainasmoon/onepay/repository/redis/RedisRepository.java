package com.rainasmoon.onepay.repository.redis;

public interface RedisRepository {
	String getValue(String id);

	void setValue(String id, String value);

	Double getValueAsDouble(String id);

	Integer getValueAsInteger(String id);
}
