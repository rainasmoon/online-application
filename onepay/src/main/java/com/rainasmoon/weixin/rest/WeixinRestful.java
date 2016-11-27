package com.rainasmoon.weixin.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.weixin.WeixinCommonConstants;
import com.rainasmoon.weixin.api.XMLUtil;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

@RestController
@RequestMapping(produces = "text/plain;charset=UTF-8")

public class WeixinRestful {

	public static Logger LOGGER = LoggerFactory.getLogger(WeixinRestful.class);

	@RequestMapping(value = "/restful/echo", method = { RequestMethod.GET })
	public String echo(@RequestParam(value = "echostr") String echostr) {
		LOGGER.info("weixin check. echo: " + echostr);
		return echostr;
	}

	@RequestMapping(value = "/restful/echo", method = { RequestMethod.POST })
	public String receiveWeixinXml(HttpServletRequest request) {
		LOGGER.debug("request:" + request);

		String requestXml = convertRequestToXml(request);

		JSONObject requestJson = convertXmlToJson(requestXml);
		// 获取accessToken
		String accessToken = WeixinCommonConstants.getAccessToken();
		String msgType = requestJson.getString("MsgType");
		LOGGER.debug("MsgType is :" + msgType);
		if ("event".equals(msgType)) {

			String FromUserName = requestJson.getString("FromUserName");
			Long CreateTime = requestJson.getLong("CreateTime");

			String event = requestJson.getString("Event");
			LOGGER.debug("Event: " + event);
			// 关注
			if (event.equals("subscribe")) {

			} else if (event.equals("unsubscribe")) {

			} else if (event.equals("VIEW")) {

				// 点击事件
			} else if (event.equals("CLICK")) {
				String eventKey = requestJson.getString("EventKey");

			} else {
				LOGGER.warn("cant deal with this weixin event: " + event);
			}

		} else if ("text".equals(msgType)) {
			String msgid = requestJson.getString("MsgId");
			String content = requestJson.getString("Content");
			String fromUserName = requestJson.getString("FromUserName");
			String toUserName = requestJson.getString("ToUserName");
			String createTime = requestJson.getString("CreateTime");

			String replayContent = "<a href=\"http://www.rainasmoon.com/\">到一元网看看吧</a>";

			return XMLUtil.createXML(createResponseJson(fromUserName, toUserName, replayContent));
		}

		return "";
	}

	private JSONObject createResponseJson(String fromUserName, String toUserName, String content) {
		JSONObject resultJson = new JSONObject();
		resultJson.put("ToUserName", fromUserName);
		resultJson.put("FromUserName", toUserName);
		resultJson.put("CreateTime", new Date().getTime());
		resultJson.put("MsgType", "text");
		resultJson.put("Content", content);

		return resultJson;
	}

	private JSONObject convertXmlToJson(String requestXml) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSONObject jsonObject = (JSONObject) xmlSerializer.read(requestXml);
		return jsonObject;
	}

	private String convertRequestToXml(HttpServletRequest request) {

		try {
			InputStream is = request.getInputStream();

			int size = request.getContentLength();
			byte[] buffer = new byte[size];
			byte[] xmlDateByte = new byte[size];
			int count = 0;
			while (count < size) {
				int len = is.read(buffer);

				for (int i = 0; i < len; i++)
					xmlDateByte[count + i] = buffer[i];
				count += len;
			}
			is.close();

			return new String(xmlDateByte, "UTF-8");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
