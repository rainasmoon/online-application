package com.rainasmoon.onepay.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifyCodeUtils {

	public static Logger LOGGER = LoggerFactory.getLogger(VerifyCodeUtils.class);

	private static Map<String, String> container = new HashMap<String, String>();

	private static Random random = new Random();

	public static String generateVerifyCode(String phone) {
		String code = rand();

		return code;
	}

	public static void put(String phone, String code) {
		container.put(phone, code);
	}

	public static boolean verify(String phone, String code) {
		if (StringUtils.isNotBlank(phone)) {
			LOGGER.warn("phone is empty.");
			return false;
		}
		if (StringUtils.isNotBlank(code)) {
			LOGGER.warn("code is empty.");
			return false;
		}
		if (container.get(phone) != null && container.get(phone).equals(code)) {
			container.remove(phone);
			return true;
		}
		return false;
	}

	public static String rand() {

		StringBuilder randomstring = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			randomstring.append(String.valueOf(random.nextInt(10)));
		}
		return randomstring.toString();
	}

}
