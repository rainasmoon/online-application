package com.hawk.application.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
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
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();  
		if (session == null) {
			LOGGER.debug("create a new session.");
			session = request.getSession(true);			
		}
		LOGGER.debug("Session Id:" + session.getId());
		String userEmail = (String) session.getAttribute("userEmail");
		LOGGER.debug("current User=========>" + userEmail);
		LOGGER.debug("request url:=========>" + uri);

		if ("login".equals(uri) || "login.html".equals(uri)
				|| "register".equals(uri) || "register.html".equals(uri)) {
			return true;
		}
		if (userEmail != null && !userEmail.isEmpty()) {
			return true;
		}
		response.sendRedirect(request.getContextPath() + "/login.html");
		return false;
	}
}