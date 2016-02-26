package com.rainasmoon.onepay.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.model.LoginVo;
import com.rainasmoon.onepay.model.User;

@Controller
public class LoginController {

	Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String initLoginForm(Map<String, Object> model) {
		LoginVo loginVo = new LoginVo();
		model.put("loginVo", loginVo);
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(@Valid LoginVo loginVo,
			BindingResult result, HttpServletRequest request,
			HttpSession session, Map<String, Object> model) {
		new LoginValidator().validate(request, loginVo, result);
		if (result.hasErrors()) {
			LOGGER.debug("Login has error.");
			return "user/login";
		} else {

			User user = userService.login(loginVo);

			if (user == null) {
				result.rejectValue("error", "error.userNameOrPassword.invalid");
				LOGGER.warn("login failed. with no user in db.");
				return "user/login";
			}

			session.setAttribute("userEmail", user.getEmail());
			LOGGER.debug("Session ID:" + session.getId());
			LOGGER.debug("Set User in session:" + user);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		LOGGER.debug("Logout running...");
		LOGGER.debug("Session ID:" + session.getId());
		session.removeAttribute("userEmail");
		session.invalidate();
		return "redirect:/";
	}
}
