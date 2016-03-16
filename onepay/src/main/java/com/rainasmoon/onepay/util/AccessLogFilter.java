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

public class AccessLogFilter implements Filter {

	public static Logger LOGGER = LoggerFactory
			.getLogger(AccessLogFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		
		String sessionId = httprequest.getRequestedSessionId();
		String url = httprequest.getRequestURL().toString();
		String userAgent = ((HttpServletRequest) request).getHeader("User-Agent");
		
		HttpSession session=((HttpServletRequest) request).getSession();
		Long loginUserId = (Long) session.getAttribute(CommonConstants.LOGIN_USER_ID);
		
		LOGGER.debug("-----------------------------------------------------------------------------");
		LOGGER.debug("ACCESS:" + getIpAddr((HttpServletRequest) request));
		LOGGER.debug("ACCESS:" + sessionId);
		LOGGER.debug("ACCESS:" + loginUserId);
		LOGGER.debug("ACCESS:" + url);
		LOGGER.debug("ACCESS:" + userAgent);
		LOGGER.debug("-----------------------------------------------------------------------------");
		
		chain.doFilter(request, response);
		return;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

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