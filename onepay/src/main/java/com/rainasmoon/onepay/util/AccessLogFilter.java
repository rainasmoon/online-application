package com.rainasmoon.onepay.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

		// LOGGER
		ServletServerHttpRequest serverRequest = new ServletServerHttpRequest((HttpServletRequest) request);
		String originRequestStr = serverRequest.getHeaders().getOrigin();

		UriComponents actualUrl = UriComponentsBuilder.fromHttpRequest(serverRequest).build();
		UriComponents originUrl = null;
		if (originRequestStr != null) {
			originUrl = UriComponentsBuilder.fromOriginHeader(originRequestStr).build();
		}
		LOGGER.debug("DEBUG:" + actualUrl.getHost());

		LOGGER.debug("DEBUG:" + actualUrl);
		LOGGER.debug("DEBUG:" + originUrl);
		LOGGER.debug("DEBUG:" + actualUrl.getHost());
		LOGGER.debug("DEBUG:" + (originUrl == null ? "null" : originUrl.getHost()));
		LOGGER.debug("DEBUG:" + actualUrl.getPort());
		LOGGER.debug("DEBUG:" + (originUrl == null ? "null" : originUrl.getPort()));
		LOGGER.debug("DEBUG:" + getPort(actualUrl));
		LOGGER.debug("DEBUG:" + (originUrl == null ? "null" : getPort(originUrl)));

		((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");

		chain.doFilter(request, response);
		return;
	}

	private static int getPort(UriComponents component) {
		int port = component.getPort();
		if (port == -1) {
			if ("http".equals(component.getScheme()) || "ws".equals(component.getScheme())) {
				port = 80;
			} else if ("https".equals(component.getScheme()) || "wss".equals(component.getScheme())) {
				port = 443;
			}
		}
		return port;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// nothing
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}