package com.hawk.mgc.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomController {

	@RequestMapping(value = { "/", "/welcome", "/welcome.html" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		// TODO check the user's roll to redirect to user page or channel page.

		return "redirect:users";
	}
}
