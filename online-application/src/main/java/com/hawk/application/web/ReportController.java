package com.hawk.application.web;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hawk.application.model.*;
import com.hawk.application.service.RedisService;

@Controller
public class ReportController {
	
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/reportNow", method = RequestMethod.GET)
	public String processFindNowReport(Map<String, Object> model) {

		List<Report> results = this.redisService
				.retriveFinancialReport();

		model.put("selections", results);
		return "report/reportToday";

	}
	@RequestMapping(value = "/reportPast", method = RequestMethod.GET)
	public String processFindPastReport(Map<String, Object> model) {

		List<Report> results = this.redisService
				.retriveFinancialReport();

		model.put("selections", results);
		return "report/reportHistory";

	}
}
