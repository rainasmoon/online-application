package com.hawk.application.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.application.model.Application;
import com.hawk.application.model.Report;
import com.hawk.application.model.SearchReportVo;
import com.hawk.application.service.ApplicationService;
import com.hawk.application.service.RedisService;

@Controller
@SessionAttributes(types = SearchReportVo.class)
public class ReportController {

	@Autowired
	private RedisService redisService;

	@Autowired
	private ApplicationService applicationService;

	@ModelAttribute("allApplications")
	public List<Application> populateAllApplicationTypes(HttpSession session) {
		String userEmail = (String) session.getAttribute("userEmail");
		List<Application> result = new ArrayList<Application>();
		Application all = new Application();
		all.setApplicationName("全部");
		result.add(all);
		result.addAll(applicationService.findAllApplications());
		return result;
	}

	@RequestMapping(value = "/reportNow", method = RequestMethod.GET)
	public String initFindNowReport(Map<String, Object> model) {

		SearchReportVo searchReportVo = new SearchReportVo.Builder().build();

		List<Report> results = this.redisService.retriveFinancialReport();

		model.put("searchReportVo", searchReportVo);
		model.put("selections", results);
		return "report/reportToday";

	}

	@RequestMapping(value = "/reportNow", method = RequestMethod.POST)
	public String processFindNowReport(SearchReportVo searchReportVo,
			Map<String, Object> model) {

		List<Report> results = this.redisService.retriveFinancialReport();

		model.put("searchReportVo", searchReportVo);
		model.put("selections", results);
		return "report/reportToday";

	}

	@RequestMapping(value = "/reportPast", method = RequestMethod.GET)
	public String initFindPastReport(Map<String, Object> model) {

		SearchReportVo searchReportVo = new SearchReportVo.Builder().build();

		List<Report> results = this.redisService.retriveFinancialReport();

		model.put("searchReportVo", searchReportVo);
		model.put("selections", results);
		return "report/reportHistory";

	}

	@RequestMapping(value = "/reportPast", method = RequestMethod.POST)
	public String processFindPastReport(SearchReportVo searchReportVo,
			Map<String, Object> model) {

		List<Report> results = this.redisService.retriveFinancialReport();

		model.put("searchReportVo", searchReportVo);
		model.put("selections", results);
		return "report/reportHistory";

	}
}