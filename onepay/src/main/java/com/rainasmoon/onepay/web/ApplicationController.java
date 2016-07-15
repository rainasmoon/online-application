package com.rainasmoon.onepay.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rainasmoon.onepay.model.ResetPasswordApplication;
import com.rainasmoon.onepay.service.ResetPasswordService;
import com.rainasmoon.onepay.util.HttpUtils;

@Controller
public class ApplicationController {

	@Autowired
	private ResetPasswordService resetPasswordService;

	@RequestMapping(value = { "/reset_password_application.html" }, method = RequestMethod.GET)
	public String showApplicationForm(Map<String, Object> model) {

		model.put("resetPasswordApplication", new ResetPasswordApplication());
		return "reset_password_application";
	}

	@RequestMapping(value = { "/reset_password_application.html" }, method = RequestMethod.POST)
	public String applyResetPassword(ResetPasswordApplication application, BindingResult result, Map<String, Object> model) {

		if (StringUtils.isBlank(application.getLoginAccount())) {
			result.rejectValue("loginAccount", "NotEmpty.loginVo.account");
		}

		if (StringUtils.isBlank(application.getDescription())) {
			result.rejectValue("description", "NotEmpty.loginVo.account");
		}

		if (StringUtils.isBlank(application.getPassword1())) {
			result.rejectValue("password1", "NotEmpty.loginVo.account");
		}

		if (StringUtils.isBlank(application.getReceiveResetEmail())) {
			result.rejectValue("receiveResetEmail", "NotEmpty.loginVo.account");
		}

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		application.setIp(HttpUtils.getIpAddr(request));
		application.setAgent(HttpUtils.getAgent(request));

		String message = resetPasswordService.addApplication(application);
		model.put("message", message);
		return "reset_password_success";
	}
}
