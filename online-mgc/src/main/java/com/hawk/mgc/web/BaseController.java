package com.hawk.mgc.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {

	public String getLoginEmail() {

		HttpSession session = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
		return (String) session.getAttribute("userName");

	}

	public String getLoginRole() {

		HttpSession session = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
		return (String) session.getAttribute("userRole");

	}
}
