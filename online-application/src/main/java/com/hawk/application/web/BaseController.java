package com.hawk.application.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {

	Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	public String getLoginEmail() {

		HttpSession session = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
		return (String) session.getAttribute("userEmail");

	}
}
