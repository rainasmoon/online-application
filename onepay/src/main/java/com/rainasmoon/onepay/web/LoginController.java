package com.rainasmoon.onepay.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.vo.LoginVo;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = { "/login.html" }, method = RequestMethod.GET)
	public String login(Map<String, Object> model) {

		LoginVo loginVo = new LoginVo();
		model.put("loginVo", loginVo);

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(@Valid LoginVo loginVo, BindingResult result, HttpServletRequest request, HttpSession session, Map<String, Object> model) {

		LOGGER.debug("Session:www:" + loginVo);

		// if exist -> login. else create

		// 1 check if userAccount exist. yes -> check password. no -> ask user what to do... create or relogin.

		return "redirect:/";

	}
}
