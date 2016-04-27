package com.rainasmoon.onepay.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServletServerHttpRequest;

public class AccessLogFilter implements Filter {

	public static Logger LOGGER = LoggerFactory.getLogger(AccessLogFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httprequest = (HttpServletRequest) request;
		String sessionId = httprequest.getRequestedSessionId();
		String url = httprequest.getRequestURL().toString();
		String userAgent = ((HttpServletRequest) request).getHeader("User-Agent");
		String origin = ((HttpServletRequest) request).getHeader(HttpHeaders.ORIGIN);

		HttpSession session = ((HttpServletRequest) request).getSession();
		Long loginUserId = (Long) session.getAttribute(CommonConstants.LOGIN_USER_ID);

		LOGGER.debug("-----------------------------------------------------------------------------");
		LOGGER.debug("ACCESS:" + getIpAddr((HttpServletRequest) request));
		LOGGER.debug("ACCESS:" + sessionId);
		LOGGER.debug("ACCESS:" + loginUserId);
		LOGGER.debug("ACCESS:" + url);
		LOGGER.debug("ACCESS:" + userAgent);
		LOGGER.debug("ACCESS:" + origin);
		LOGGER.debug("-----------------------------------------------------------------------------");

		// check uri.getHost()

		// LOGGER
		ServletServerHttpRequest serverRequest = new ServletServerHttpRequest((HttpServletRequest) request);

		LOGGER.debug("headers:" + serverRequest.getHeaders());

		chain.doFilter(request, response);
		return;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// nothing
	}

	public String getIpAddr(HttpServletRequest request) {
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
}