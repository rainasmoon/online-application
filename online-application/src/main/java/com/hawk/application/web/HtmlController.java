package com.hawk.application.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hawk.application.model.Report;

@Controller
public class HtmlController {

	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faq() {
		
		return "staticpage/faq";

	}
}
