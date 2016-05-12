package com.rainasmoon.onepay.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.ResetPasswordApplication;
import com.rainasmoon.onepay.service.ResetPasswordService;

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
	public String applyResetPassword(@Valid ResetPasswordApplication application, Map<String, Object> model) {
		String message = resetPasswordService.addApplication(application);
		model.put("message", message);
		return "reset_password_success";
	}
}
