package com.rainasmoon.onepay.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {

	public static Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

	public static String getIpAddr(HttpServletRequest request) {
		String ipFromNginx = request.getHeader("X-Real-IP");
		String ip = request.getHeader("x-forwarded-for");

		LOGGER.debug("X-Real-IP:" + ipFromNginx);
		LOGGER.debug("x-forwarded-for:" + ip);

		if (StringUtils.isNotBlank(ipFromNginx)) {
			return ipFromNginx;
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			LOGGER.debug("Proxy-Client-IP:" + ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			LOGGER.debug("WL-Proxy-Client-IP:" + ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			LOGGER.debug("getRemoteAddr:" + ip);
		}
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			LOGGER.debug("headers name:" + headerNames.nextElement());
		}

		return ip;
	}

	public static String getAgent(HttpServletRequest request) {
		String userAgent = request.getHeader("User-Agent");

		return userAgent;
	}
}
