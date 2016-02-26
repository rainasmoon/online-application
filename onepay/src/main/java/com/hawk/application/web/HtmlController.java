package com.hawk.application.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HtmlController {

	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faq() {
		
		return "staticpage/faq";

	}
}
