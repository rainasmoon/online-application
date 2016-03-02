package com.rainasmoon.onepay.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController extends BaseController {

	@RequestMapping(value = { "/login.html" }, method = RequestMethod.GET)
	public String login(Map<String, Object> model) {

		return "login";
	}

	@RequestMapping(value = { "/top10users.html" }, method = RequestMethod.GET)
	public String listTop10Users(Map<String, Object> model) {

		return "top10users";
	}
}
