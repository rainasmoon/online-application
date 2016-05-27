package com.rainasmoon.onepay.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class MessageUtils {

	public static Logger LOGGER = LoggerFactory.getLogger(MessageUtils.class);

	private String url = "http://gw.api.taobao.com/router/rest";
	private String appkey = "23368055";
	private String secret = "2e6150177b3c7894bce257b630b82561";

	public boolean sendVerifyCode(String phone, String name, String code) {
		try {
			return sendPhoneMessage(phone, "{name:'" + name + "',code:'" + code + "'}", "SMS_9980047");
		} catch (ApiException e) {
			LOGGER.error("send phone msg error:", e);
		}

		return false;
	}

	public boolean sendNotice(String phone, String productName, String status) {
		try {
			return sendPhoneMessage(phone, "{product:'" + productName + "',status:'" + status + "'}", "SMS_9970017");
		} catch (ApiException e) {
			LOGGER.error("send phone msg error:", e);
		}

		return false;
	}

	private boolean sendPhoneMessage(String phone, String param, String template) throws ApiException {

		LOGGER.info("send phone msg to :" + phone + ". param:" + param + ". template:" + template);

		if (!CommonValidators.isMobile(phone)) {
			LOGGER.warn("send phone num is illegal:" + phone);
			return false;
		}

		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("12345");
		req.setSmsType("normal");
		req.setSmsFreeSignName("一元网");
		req.setSmsParamString(param);
		req.setRecNum(phone);
		req.setSmsTemplateCode(template);
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		LOGGER.info(rsp.getBody());

		return rsp.getResult().getSuccess();
	}

}
