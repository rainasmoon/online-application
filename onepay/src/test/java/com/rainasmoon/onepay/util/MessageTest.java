package com.rainasmoon.onepay.util;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageTest {

	@Test
	public void testSend() {
		// new MessageUtils().send("15811015803", "Glen", "testCode");

		new MessageUtils().sendVerifyCode("13691300925", "Glen", "testCode");
	}

	@Test
	public void testSendNotice() {
		// new MessageUtils().send("15811015803", "Glen", "testCode");

		new MessageUtils().sendNotice("13691300925", "Gold", "testStatus");
	}

	@Test
	public void testJackson() throws JsonParseException, JsonMappingException, IOException {
		String body = "{\"alibaba_aliqin_fc_sms_num_send_response\":{\"result\":{\"err_code\":\"0\",\"model\":\"101718715768^1102270454272\",\"success\":true},\"request_id\":\"z26rvtk8byne\"}}";
		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Map<String, Map<String, Object>>> maps = objectMapper.readValue(body, Map.class);

		System.out.println("Result:" + maps.get("alibaba_aliqin_fc_sms_num_send_response").get("result").get("success"));

	}

}
