package com.rainasmoon.weixin.api;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rainasmoon.weixin.WeixinCommonConstants;

import net.sf.json.JSONObject;

public class WeixinApi {

	public static Logger LOGGER = LoggerFactory.getLogger(WeixinApi.class);

	public static String getAccessToken() {

		try {
			LOGGER.info("weixin test");

			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + WeixinCommonConstants.APPID + "&secret=" + WeixinCommonConstants.APPSECRET;

			String responseXml = "";
			// 创建默认的httpClient实例.
			CloseableHttpClient httpclient = HttpClients.createDefault();
			// 创建httppost
			HttpPost httppost = new HttpPost(url);

			JSONObject param = new JSONObject();
			param.put("url", "");
			param.put("data", "");
			param.put("method", "get");

			byte[] sendBuffer = param.toString().getBytes("UTF-8");
			ByteArrayEntity sendContent = new ByteArrayEntity(sendBuffer);

			sendContent.setContentType("application/json");

			sendContent.setContentEncoding("UTF-8");
			httppost.setEntity(sendContent);

			CloseableHttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseXml = EntityUtils.toString(entity, "UTF-8");
			}
			response.close();
			// 关闭连接,释放资源
			httpclient.close();

			LOGGER.info("call api to get access token is: " + responseXml);

			JSONObject jsonObject = JSONObject.fromObject(responseXml);

			String accessToken = (String) jsonObject.get("access_token");

			LOGGER.info("the access token result is " + accessToken);

			return accessToken;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
