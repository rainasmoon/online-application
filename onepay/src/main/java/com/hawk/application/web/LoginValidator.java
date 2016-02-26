package com.hawk.application.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;

import com.hawk.application.model.LoginVo;
import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

public class LoginValidator {
	Logger LOGGER = LoggerFactory.getLogger(LoginValidator.class);
	
	public void validate(HttpServletRequest request, LoginVo loginVo,
			Errors errors) {

		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(
				request, loginVo.getCheckCode());
		if (!captchaPassed) {			
			LOGGER.info("captcha failed. " + loginVo.getCheckCode());
			errors.rejectValue("checkCode", "error.checkCode.invalid");
		}
		

	}

}
