package com.rainasmoon.onepay.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelpController {

	@RequestMapping(value = { "/help.html" }, method = RequestMethod.GET)
	public String help(Map<String, Object> model) {

		return "help";
	}

	@RequestMapping(value = { "/agreement.html" }, method = RequestMethod.GET)
	public String agreement(Map<String, Object> model) {

		return "agreement";
	}
}
