package com.rainasmoon.onepay.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rainasmoon.onepay.model.WelcomeVo;

@Controller
@SessionAttributes(types = WelcomeVo.class)
public class WelcomController extends BaseController {

	@RequestMapping(value = { "/", "/welcome", "/welcome.html" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {

		return "index";
	}
}
