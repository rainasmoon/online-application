package com.rainasmoon.onepay.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {

	public static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	public static String SYS_PIC_PATH;

	public Long getLoginUserId() {

		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		return (Long) session.getAttribute("userId");

	}

	public void setSessionLoginUser(Long userId) {

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
		return getLoginUserId() != null;
	}
}
