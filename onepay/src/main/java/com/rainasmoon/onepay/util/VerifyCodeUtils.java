package com.rainasmoon.onepay.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VerifyCodeUtils {
	private static Map<String, String> container = new HashMap<String, String>();

	private static Random random = new Random();

	public static String generateVerifyCode(String phone) {
		String code = rand();
		container.put(phone, code);
		return code;
	}

	public static boolean verify(String phone, String code) {
		if (container.get(phone).equals(code)) {
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
