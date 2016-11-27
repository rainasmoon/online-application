package com.rainasmoon.weixin;

import java.util.ArrayList;
import java.util.List;

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

import com.rainasmoon.weixin.api.Button;
import com.rainasmoon.weixin.api.SubButton;
import com.rainasmoon.weixin.api.View;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeixinTest {

	private static final String APPID = "wxc0c285014370ed82";
	private static final String APPSECRET = "82689230d1cbb40dea18e5218ed029e4";
	private static Logger LOGGER = LoggerFactory.getLogger(WeixinTest.class);

	private static String ACCESS_TOKEN = "1C30Xf48aK9fzN97M_Z4kTT4uDeLyBcTzxbMWAEwLBKXNIDr4qTnJis7cz6Cjuyu5-W-YdKyuRrARTkC7yuRyFYKu019l5rG91xAWuzJ_FMoUHon_xx1RoDMXIr6281-LSBgABAPWF";

	@Test
	public void testGetAccessToken() throws Exception {
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

	@Test
	public void testCreateMenu() throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + ACCESS_TOKEN;

		JSONArray buttonjson = new JSONArray();

		Button button = new Button();
		button.setName("A");
		button.setUrl("http://www.wanlianjin.com");
		// click,view
		button.setType("click");
		List<SubButton> sub_button = new ArrayList<>();

		SubButton subButton = new SubButton();
		subButton = new View("B", "http://www.rainasmoon.com");
		sub_button.add(subButton);

		button.setSub_button(sub_button);
		buttonjson.add(button);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("button", buttonjson);

		callWeiXinWeb(url, jsonObject, "post");
	}

	private static JSONObject callWeiXinWeb(String url, Object data, String method) {
		try {
			LOGGER.info("call weixin service web service.");
			String responseXml = "";
			// 创建默认的httpClient实例.
			CloseableHttpClient httpclient = HttpClients.createDefault();
			// 创建httppost
			HttpPost httppost = new HttpPost(url);

			JSONObject param = new JSONObject();
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

			LOGGER.info("call api to get weixin response is: " + responseXml);

			JSONObject jsonObject = JSONObject.fromObject(responseXml);

			return jsonObject;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
