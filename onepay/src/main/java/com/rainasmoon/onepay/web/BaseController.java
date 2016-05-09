package com.rainasmoon.onepay.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rainasmoon.onepay.util.CommonConstants;

public class BaseController {

	public static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	public static String SYS_PIC_PATH;

	public Long getLoginUserId() {

		try {
			checkCookieUser();
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("UnsupportedEncodingException", e);
			e.printStackTrace();
		}

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		HttpSession session = request.getSession();
		return (Long) session.getAttribute(CommonConstants.LOGIN_USER_ID);

	}

	private void checkCookieUser() throws UnsupportedEncodingException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		Long userId = null;
		String userShowName = null;

		// deal with cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(CommonConstants.LOGIN_USER_ID)) {
				userId = Long.parseLong(cookie.getValue());

			} else if (cookie.getName().equals(CommonConstants.LOGIN_USER_SHOW_NAME)) {
				userShowName = URLDecoder.decode(cookie.getValue(), "utf-8");
			}

			if (userId != null && userShowName != null) {
				setSessionLoginUser(userId, userShowName);
				break;
			}
		}

	}

	public void setCookieLogin(Long userId, String userShowName) {

		try {
			addLoginToCookie(userId, userShowName);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("UnsupportedEncodingException", e);
			e.printStackTrace();
		}

	}

	private void addLoginToCookie(Long userId, String userShowName) throws UnsupportedEncodingException {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

		Cookie cid = new Cookie(CommonConstants.LOGIN_USER_ID, userId.toString());

		Cookie cshowname = new Cookie(CommonConstants.LOGIN_USER_SHOW_NAME, URLEncoder.encode(userShowName, "utf-8"));
		cid.setMaxAge(365 * 24 * 3600);
		cshowname.setMaxAge(365 * 24 * 3600);

		response.addCookie(cid);
		response.addCookie(cshowname);

	}

	public void setSessionLoginUser(Long userId, String userShowName) {

		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		session.setAttribute(CommonConstants.LOGIN_USER_ID, userId);
		session.setAttribute(CommonConstants.LOGIN_USER_SHOW_NAME, userShowName);

	}

	public void setSessionOut() {
		LOGGER.debug("Logout running...");
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		LOGGER.debug("Session ID:" + session.getId());
		session.removeAttribute(CommonConstants.LOGIN_USER_ID);
		session.removeAttribute(CommonConstants.LOGIN_USER_SHOW_NAME);
		session.invalidate();
	}

	public boolean isLogin() {

		return getLoginUserId() != null;
	}
}
