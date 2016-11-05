package com.rainasmoon.onepay.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

		String origin = ((HttpServletRequest) request).getHeader(HttpHeaders.ORIGIN);

		HttpSession session = ((HttpServletRequest) request).getSession();
		Long loginUserId = (Long) session.getAttribute(CommonConstants.LOGIN_USER_ID);

		LOGGER.debug("-----------------------------------------------------------------------------");
		LOGGER.debug("ACCESS:" + HttpUtils.getIpAddr((HttpServletRequest) request));
		LOGGER.debug("ACCESS:" + sessionId);
		LOGGER.debug("ACCESS:" + loginUserId);
		LOGGER.debug("ACCESS:" + url);
		LOGGER.debug("ACCESS:" + HttpUtils.getAgent((HttpServletRequest) request));
		LOGGER.debug("ACCESS:" + origin);
		LOGGER.debug("-----------------------------------------------------------------------------");

		// check uri.getHost()

		// LOGGER
		ServletServerHttpRequest serverRequest = new ServletServerHttpRequest((HttpServletRequest) request);

		LOGGER.debug("headers:" + serverRequest.getHeaders());

		if ("HEAD".equals(httprequest.getMethod())) {
			LOGGER.warn("CONVERT the rquest HEAD to GET.");
			LOGGER.info("the url is" + url);
			chain.doFilter(request, response);
		} else {
			chain.doFilter(request, response);
		}
		return;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// nothing
	}

}