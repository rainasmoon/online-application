package com.rainasmoon.weixin.api;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

public class XMLUtil {
	// 回复文本消息
	public static String createXML(JSONObject jsonObject) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<xml>");
		buffer.append("<ToUserName><![CDATA[" + jsonObject.getString("ToUserName") + "]]></ToUserName>");
		buffer.append("<FromUserName><![CDATA[" + jsonObject.getString("FromUserName") + "]]></FromUserName>");
		buffer.append("<CreateTime>" + jsonObject.getString("CreateTime") + "</CreateTime>");
		buffer.append("<MsgType><![CDATA[" + jsonObject.getString("MsgType") + "]]></MsgType>");
		buffer.append("<Content><![CDATA[" + jsonObject.getString("Content") + "]]></Content>");
		buffer.append("</xml>");
		return buffer.toString();
	}

	// 回复链接消息
	public static String createXML5(JSONObject jsonObject) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<xml>");
		buffer.append("<ToUserName><![CDATA[" + jsonObject.getString("ToUserName") + "]]></ToUserName>");
		buffer.append("<FromUserName><![CDATA[" + jsonObject.getString("FromUserName") + "]]></FromUserName>");
		buffer.append("<CreateTime>" + jsonObject.getString("CreateTime") + "</CreateTime>");
		buffer.append("<MsgType><![CDATA[" + jsonObject.getString("MsgType") + "]]></MsgType>");

		buffer.append("<ArticleCount>" + 1 + "</ArticleCount>");
		buffer.append("<Articles>");
		buffer.append("<item>");
		buffer.append("<Title><![CDATA[" + jsonObject.getString("title") + "]]></Title>");
		buffer.append("<Description><![CDATA[" + jsonObject.getString("digest") + "]]></Description>");
		buffer.append("<PicUrl><![CDATA[" + jsonObject.getString("PicUrl") + "]]></PicUrl>");
		buffer.append("<Url><![CDATA[" + jsonObject.getString("url") + "]]></Url>");
		buffer.append("</item>");
		buffer.append("</Articles>");

		buffer.append("</xml>");

		return buffer.toString();

	}

	// 回复图文消息
	public static String createXML4(JSONObject jsonObject) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<xml>");
		buffer.append("<ToUserName><![CDATA[" + jsonObject.getString("ToUserName") + "]]></ToUserName>");
		buffer.append("<FromUserName><![CDATA[" + jsonObject.getString("FromUserName") + "]]></FromUserName>");
		buffer.append("<CreateTime>" + jsonObject.getString("CreateTime") + "</CreateTime>");
		buffer.append("<MsgType><![CDATA[" + jsonObject.getString("MsgType") + "]]></MsgType>");
		int k = jsonObject.getJSONArray("item").size();

		buffer.append("<ArticleCount>" + k + "</ArticleCount>");
		buffer.append("<Articles>");

		for (int i = 0; i < k; i++) {
			buffer.append("<item>");
			buffer.append("<Title><![CDATA[" + jsonObject.getJSONArray("item").getJSONObject(i).getString("title") + "]]></Title>");
			buffer.append("<Description><![CDATA[" + jsonObject.getJSONArray("item").getJSONObject(0).getString("digest") + "]]></Description>");
			buffer.append("<PicUrl><![CDATA[" + jsonObject.getJSONArray("item").getJSONObject(i).getString("PicUrl") + "]]></PicUrl>");
			buffer.append("<Url><![CDATA[" + jsonObject.getJSONArray("item").getJSONObject(i).getString("url") + "]]></Url>");
			buffer.append("</item>");

		}
		buffer.append("</Articles>");

		buffer.append("</xml>");

		return buffer.toString();

	}

	// 回复图片消息
	public static String createXML1(JSONObject jsonObject) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<xml>");
		buffer.append("<ToUserName><![CDATA[" + jsonObject.getString("ToUserName") + "]]></ToUserName>");
		buffer.append("<FromUserName><![CDATA[" + jsonObject.getString("FromUserName") + "]]></FromUserName>");
		buffer.append("<CreateTime>" + jsonObject.getString("CreateTime") + "</CreateTime>");
		buffer.append("<MsgType><![CDATA[" + jsonObject.getString("MsgType") + "]]></MsgType>");
		buffer.append("<Image>");
		buffer.append("<MediaId><![CDATA[" + jsonObject.getString("MediaId") + "]]></MediaId>");
		buffer.append("</Image>");
		buffer.append("</xml>");
		return buffer.toString();
	}

	// 回复视频消息
	public static String createXML3(JSONObject jsonObject) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<xml>");
		buffer.append("<ToUserName><![CDATA[" + jsonObject.getString("ToUserName") + "]]></ToUserName>");
		buffer.append("<FromUserName><![CDATA[" + jsonObject.getString("FromUserName") + "]]></FromUserName>");
		buffer.append("<CreateTime>" + jsonObject.getString("CreateTime") + "</CreateTime>");
		buffer.append("<MsgType><![CDATA[" + jsonObject.getString("MsgType") + "]]></MsgType>");
		buffer.append("<Video>");
		buffer.append("<MediaId><![CDATA[" + jsonObject.getString("MediaId") + "]]></MediaId>");
		buffer.append("<Title><![CDATA[" + jsonObject.getString("Title") + "]]></Title>");
		buffer.append("<Description><![CDATA[" + jsonObject.getString("Description") + "]]></Description>");
		buffer.append("</Video>");
		buffer.append("</xml>");
		return buffer.toString();
	}

	// 回复语音消息
	public static String createXML2(JSONObject jsonObject) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<xml>");
		buffer.append("<ToUserName><![CDATA[" + jsonObject.getString("ToUserName") + "]]></ToUserName>");
		buffer.append("<FromUserName><![CDATA[" + jsonObject.getString("FromUserName") + "]]></FromUserName>");
		buffer.append("<CreateTime>" + jsonObject.getString("CreateTime") + "</CreateTime>");
		buffer.append("<MsgType><![CDATA[" + jsonObject.getString("MsgType") + "]]></MsgType>");
		buffer.append("<Voice>");
		buffer.append("<MediaId><![CDATA[" + jsonObject.getString("MediaId") + "]]></MediaId>");
		buffer.append("</Voice>");
		buffer.append("</xml>");
		return buffer.toString();
	}

	/**
	 * map转成xml
	 * 
	 * @param arr
	 * @return
	 */
	public static String ArrayToXml(Map<String, String> arr) {
		String xml = "<xml>";

		Iterator<Entry<String, String>> iter = arr.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String val = entry.getValue();
			xml += "<" + key + ">" + val + "</" + key + ">";
		}
		xml += "</xml>";
		return xml;
	}

	public static String wxfhXml(String user_name, String user_psw, String transrno, String serialdecimal, String transrdate, String RESULTCODE, String sERIALDECIMAL) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>" + "\r\n");
		sb.append("<INSUREQRET>" + "\r\n");
		sb.append("<HEAD>" + "\r\n");
		sb.append("<USER_NAME>" + user_name + "</USER_NAME>" + "\r\n");
		sb.append("<USER_PSW>" + user_psw + "</USER_PSW>" + "\r\n");
		sb.append("</HEAD>" + "\r\n");
		sb.append("<BASE>" + "\r\n");
		sb.append("<TRANSRNO>" + transrno + "</TRANSRNO>" + "\r\n");
		sb.append("<SERIALDECIMAL>" + serialdecimal + "</SERIALDECIMAL>" + "\r\n");
		sb.append("<TRANSRDATE>" + transrdate + "</TRANSRDATE>" + "\r\n");
		sb.append("</BASE>" + "\r\n");
		sb.append("<MAIN>" + "\r\n");
		sb.append("<RESULTCODE>" + RESULTCODE + "</RESULTCODE>" + "\r\n");
		sb.append("<ERR_INFO>" + sERIALDECIMAL + "</ERR_INFO>" + "\r\n");
		sb.append("</MAIN>" + "\r\n");
		sb.append("</INSUREQRET>" + "\r\n");
		return sb.toString();

	}

}
