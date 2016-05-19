package com.rainasmoon.onepay.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncodeUtils {

	public static Logger LOGGER = LoggerFactory.getLogger(EncodeUtils.class);
	public static final String KEY = "YqdAbaQ&A68HuEYH";

	public static String encrypt(String function, String content) {
		try {
			return java.net.URLEncoder.encode(DESUtils.encrypt(function + "_" + content, KEY), CommonConstants.UTF_8);
		} catch (Exception e) {
			LOGGER.warn("ERROR:", e);
		}
		return null;
	}

	public static String decrypt(String content) {
		try {

			return DESUtils.decrypt(java.net.URLDecoder.decode(content, CommonConstants.UTF_8), KEY);
		} catch (Exception e) {
			LOGGER.warn("ERROR:", e);
		}
		return null;
	}

	public static Map<String, String> decryptToMap(String content) {
		String decrptedContent = decrypt(content);
		String[] items = decrptedContent.split("_");
		if (items.length != 2) {
			return null;
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("function", items[0]);
		result.put("value", items[1]);
		return result;

	}
}
