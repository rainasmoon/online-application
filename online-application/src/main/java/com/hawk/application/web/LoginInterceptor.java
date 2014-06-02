package com.hawk.application.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hawk.application.model.User;

public class LoginInterceptor implements HandlerInterceptor {

	Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception err)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		String uri = request.getRequestURI().substring(
				request.getRequestURI().lastIndexOf("/") + 1);
		User user = (User) request.getSession(true).getAttribute("user");
		LOGGER.debug("str=========>" + user);
		LOGGER.debug("str=========>" + uri);

		if ("login".equals(uri) || "login.html".equals(uri)
				|| "register".equals(uri) || "register.html".equals(uri)) {
			return true;
		}
		if (user != null && user.getEmail() != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath() + "/login.html");
		return false;
	}
}