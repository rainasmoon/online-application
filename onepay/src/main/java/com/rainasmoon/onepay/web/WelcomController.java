package com.rainasmoon.onepay.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rainasmoon.onepay.service.RedisService;
import com.rainasmoon.onepay.model.WelcomeVo;

@Controller
@SessionAttributes(types = WelcomeVo.class)
public class WelcomController extends BaseController {

	@Autowired
	private RedisService redisService;

	@RequestMapping(value = { "/", "/welcome", "/welcome.html" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {

		model.put("welcomeVo", redisService.retriveWelcomeInfo(getLoginEmail()));
		return "common/welcome";
	}
}
