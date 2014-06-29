package com.hawk.mgc.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomController extends BaseController {

	@RequestMapping(value = { "/", "/welcome", "/welcome.html" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {

		if (getLoginRole().equals("manager")) {
			return "redirect:users";
		} else {
			return "redirect:channels";
		}
	}
}
