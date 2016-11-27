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

			return dealEvent(requestJson);

		} else if ("text".equals(msgType)) {
			return dealText(requestJson);
		} else if ("image".equals(msgType)) {
		} else if ("voice".equals(msgType)) {

		} else if ("video".equals(msgType)) {

		} else if ("shortvideo".equals(msgType)) {

		} else if ("location".equals(msgType)) {

		} else if ("link".equals(msgType)) {

		} else {
			LOGGER.warn("can't deal this weixin msg type :" + msgType);
		}

		return "";
	}

	private String dealText(JSONObject requestJson) {
		String msgid = requestJson.getString("MsgId");
		String content = requestJson.getString("Content");
		String fromUserName = requestJson.getString("FromUserName");
		String toUserName = requestJson.getString("ToUserName");
		String createTime = requestJson.getString("CreateTime");

		String replayContent = "<a href=\"http://www.rainasmoon.com/\">到一元网看看吧</a>";
		String oldMsgs = "<a href=\"http://mp.weixin.qq.com/mp/getmasssendmsg?__biz=MzI4MDE3NDc3Mg==&from=1#wechat_webview_type=1&wechat_redirect\">ALL</a>";
		// http://mp.weixin.qq.com/s?__biz=MzI4MDE3NDc3Mg==&mid=2650283589&idx=1&sn=06db818f3c11437ac4adba3ba67265e1&chksm=f3b0379ec4c7be88252f15de9709f8819d5ac71b170e4aca83eb66c6ea003544134abb43604f#rd
		if (content.equals("乱") || content.contains("0")) {
			return createResponseXmlNews(fromUserName, toUserName, replayContent);
		}
		return XMLUtil.createXML(createResponseJsonText(fromUserName, toUserName, oldMsgs));

	}

	private String dealEvent(JSONObject requestJson) {
		String FromUserName = requestJson.getString("FromUserName");
		Long CreateTime = requestJson.getLong("CreateTime");

		String event = requestJson.getString("Event");
		String eventKey = requestJson.getString("EventKey");

		LOGGER.debug("Event: " + event);
		LOGGER.debug("EventKey: " + eventKey);
		// 关注
		if (event.equals("subscribe")) {
			if (eventKey.startsWith("qrscene_")) {
			}
		} else if (event.equals("unsubscribe")) {

		} else if (event.equals("SCAN")) {

		} else if (event.equals("LOCATION")) {

		} else if (event.equals("VIEW")) {

			// 点击事件
		} else if (event.equals("CLICK")) {

		} else {
			LOGGER.warn("cant deal with this weixin event: " + event);
		}

		return null;
	}

	private JSONObject createResponseJsonText(String toUserName, String fromUserName, String content) {
		JSONObject resultJson = new JSONObject();
		resultJson.put("ToUserName", toUserName);
		resultJson.put("FromUserName", fromUserName);
		resultJson.put("CreateTime", new Date().getTime());
		resultJson.put("MsgType", "text");
		resultJson.put("Content", content);

		return resultJson;
	}

	private String createResponseXmlNews(String toUserName, String fromUserName, String content) {
		return "<xml>" + "<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>" + "<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>" + "<CreateTime>" + new Date().getTime() + "</CreateTime>" + "<MsgType><![CDATA[news]]></MsgType>" + "<ArticleCount>1</ArticleCount>" + "<Articles>" + "<item>" + "<Title><![CDATA[title1]]></Title> " + "<Description><![CDATA[description1]]></Description>" + "<PicUrl><![CDATA[picurl]]></PicUrl>" + "<Url><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDE3NDc3Mg==&mid=2650283589&idx=1&sn=06db818f3c11437ac4adba3ba67265e1&chksm=f3b0379ec4c7be88252f15de9709f8819d5ac71b170e4aca83eb66c6ea003544134abb43604f#rd]]></Url>" + "</item>" + "</Articles>" + "</xml>";
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
