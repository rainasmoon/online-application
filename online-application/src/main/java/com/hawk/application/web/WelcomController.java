package com.hawk.application.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.application.model.WelcomeVo;
import com.hawk.application.service.RedisService;

@Controller
@SessionAttributes(types = WelcomeVo.class)
public class WelcomController {

	@Autowired
	private RedisService redisService;

	@RequestMapping(value = { "/", "/welcome", "/welcome.html" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {

		model.put("welcomeVo", redisService.retriveWelcomeInfo());
		return "welcome";
	}
}
