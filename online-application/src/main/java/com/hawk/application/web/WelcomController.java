package com.hawk.application.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.application.model.WelcomeVo;

@Controller
@SessionAttributes(types = WelcomeVo.class)
public class WelcomController {

	@RequestMapping(value = { "/", "/welcome", "/welcome.html" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		WelcomeVo welcomeVo = new WelcomeVo();
		welcomeVo.setTodayIncome(123.26);
		welcomeVo.setTodayPromotedUsers(80);
		welcomeVo.setTodayUsers(50);
		welcomeVo.setYesterdayIncome(100.0);
		welcomeVo.setYesterdayPromotedUsers(100);
		welcomeVo.setYesterdayUsers(20);
		welcomeVo.setTotalBanlance(12300.68);

		model.put("welcomeVo", welcomeVo);
		return "welcome";
	}
}
