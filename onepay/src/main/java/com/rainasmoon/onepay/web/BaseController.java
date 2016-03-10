package com.rainasmoon.onepay.web;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {

	Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	public static String SYS_PIC_PATH;

	public String getLoginUserId() {

		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		return (String) session.getAttribute("userId");

	}

	public void setSessionLoginUser(String userId) {

		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		session.setAttribute("userId", userId);

	}

	public void setSessionOut() {
		LOGGER.debug("Logout running...");
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		LOGGER.debug("Session ID:" + session.getId());
		session.removeAttribute("userId");
		session.invalidate();
	}

	public boolean isLogin() {
		return StringUtils.isNotBlank(getLoginUserId());
	}
}
