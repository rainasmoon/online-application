package com.rainasmoon.weixin;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class WeixinTest {

	private static final String APPID = "wxc0c285014370ed82";
	private static final String APPSECRET = "82689230d1cbb40dea18e5218ed029e4";
	Logger LOGGER = LoggerFactory.getLogger(WeixinTest.class);

	private static String ACCESS_TOKEN = "iK1srsYNZ9dd-xifILfU-RUK6KVbg8ZDrF-q4xuGA_d5SxOl2u9EeVo1WBYEZDOI0Vd9JqB9SLCG5V42S06mzo2sOCz34QyHOtTtdLGpfbjMki8UvnjA7z7YLMEpsYBKZVMdAEAIEV";

	// HVyFiHWk1SZPKRa3RsefjjLn6jKFr7B76wUiDF8gZ0g

	@Test
	public void testWeixin() throws Exception {
		LOGGER.info("weixin test");

		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET;

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

	}

	@Test
	public void testWeixinGetIps() throws Exception {
		LOGGER.info("weixin test");

		String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=" + ACCESS_TOKEN;

		String responseXml = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(url);

		JSONObject param = new JSONObject();

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

		LOGGER.info("result: " + responseXml);

	}
}
