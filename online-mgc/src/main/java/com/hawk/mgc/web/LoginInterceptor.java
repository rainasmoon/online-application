package com.hawk.mgc.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
		if (session == null) {
			LOGGER.debug("create a new session.");
			session = request.getSession(true);
		}
		LOGGER.debug("Session Id:" + session.getId());
		String userEmail = (String) session.getAttribute("userName");
		String userRole = (String) session.getAttribute("userRole");
		LOGGER.debug("current User=========>" + userEmail);
		LOGGER.debug("request url:=========>" + uri);

		if ("login".equals(uri) || "login.html".equals(uri)
				|| "register".equals(uri) || "register.html".equals(uri)) {
			return true;
		}
		if (userEmail != null && !userEmail.isEmpty()) {
			if (checkRole(uri, userRole)) {
				return true;
			}
		}

		response.sendRedirect(request.getContextPath() + "/login.html");
		return false;
	}

	private boolean checkRole(String uri, String userRole) {
		List<String> managerRoleUri = new ArrayList<String>();
		managerRoleUri.add("users");
		managerRoleUri.add("users.html");
		managerRoleUri.add("packages");
		managerRoleUri.add("packages.html");
		managerRoleUri.add("edit");
		managerRoleUri.add("edit.html");
		managerRoleUri.add("add.html");
		managerRoleUri.add("add");
		managerRoleUri.add("new.html");
		managerRoleUri.add("new");
		managerRoleUri.add("delete.html");
		managerRoleUri.add("delete");
		managerRoleUri.add("listDetails");
		managerRoleUri.add("listDetails.html");

		if (managerRoleUri.contains(uri) && !"manager".equals(userRole)) {
			return false;
		}
		return true;
	}
}