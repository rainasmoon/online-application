package com.rainasmoon.weixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rainasmoon.weixin.api.WeixinApi;

public class WeixinCommonConstants {

	public static final String APPID = "wxc0c285014370ed82";
	public static final String APPSECRET = "82689230d1cbb40dea18e5218ed029e4";
	private Logger LOGGER = LoggerFactory.getLogger(WeixinCommonConstants.class);

	private static String ACCESS_TOKEN;

	public static String getAccessToken() {
		if (ACCESS_TOKEN == null) {
			ACCESS_TOKEN = WeixinApi.getAccessToken();
		}
		return ACCESS_TOKEN;
	}

}
