package com.rainasmoon.weixin.api;

import java.util.ArrayList;
import java.util.List;

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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeixinApi {

	private static final String URL_WX_CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	private static final String URL_WX_GET_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	public static Logger LOGGER = LoggerFactory.getLogger(WeixinApi.class);

	public static String getAccessToken() {

		String url = URL_WX_GET_TOKEN + "&appid=" + WeixinCommonConstants.APPID + "&secret=" + WeixinCommonConstants.APPSECRET;

		JSONObject jsonObject = callWeiXinWeb(url, null, "get");

		String accessToken = (String) jsonObject.get("access_token");

		LOGGER.info("the access token result is " + accessToken);

		return accessToken;

	}

	public static void createWinXinMenu() {
		String url = URL_WX_CREATE_MENU + WeixinCommonConstants.getAccessToken();

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
