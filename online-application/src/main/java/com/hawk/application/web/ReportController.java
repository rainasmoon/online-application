package com.hawk.application.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class ReportController extends BaseController {

	@Autowired
	private RedisService redisService;

	@Autowired
	private ApplicationService applicationService;

	@ModelAttribute("allApplications")
	public List<Application> populateAllApplicationTypes() {

		List<Application> result = new ArrayList<Application>();
		Application all = new Application();
		all.setApplicationName("全部");
		result.add(all);
		result.addAll(applicationService.findAllApplications(getLoginEmail()));
		return result;
	}

	@RequestMapping(value = "/reportNow", method = RequestMethod.GET)
	public String initFindNowReport(Map<String, Object> model) {

		SearchReportVo searchReportVo = new SearchReportVo.Builder().build();

		Date today = new Date();
		searchReportVo.setDateFrom(new Date(today.getTime() - 24 * 60 * 60
				* 1000));
		searchReportVo.setDateTo(today);

		List<Report> results = this.redisService.retriveFinancialReport(
				getLoginEmail(), searchReportVo);

		model.put("searchReportVo", searchReportVo);
		model.put("selections", results);
		return "report/reportToday";

	}

	@RequestMapping(value = "/reportNow", method = RequestMethod.POST)
	public String processFindNowReport(SearchReportVo searchReportVo,
			Map<String, Object> model) {

		Date today = new Date();
		searchReportVo.setDateFrom(new Date(today.getTime() - 24 * 60 * 60
				* 1000));
		searchReportVo.setDateTo(today);

		List<Report> results = this.redisService.retriveFinancialReport(
				getLoginEmail(), searchReportVo);

		model.put("selections", results);
		return "report/reportToday";

	}

	@RequestMapping(value = "/reportPast", method = RequestMethod.GET)
	public String initFindPastReport(Map<String, Object> model) {

		SearchReportVo searchReportVo = new SearchReportVo.Builder().build();

		Date today = new Date();
		searchReportVo.setDateFrom(new Date(today.getTime() - 7 * 24 * 60 * 60
				* 1000));
		searchReportVo.setDateTo(today);

		List<Report> results = this.redisService.retriveFinancialReport(
				getLoginEmail(), searchReportVo);

		model.put("searchReportVo", searchReportVo);
		model.put("selections", results);
		return "report/reportHistory";

	}

	@RequestMapping(value = "/reportPast", method = RequestMethod.POST)
	public String processFindPastReport(SearchReportVo searchReportVo,
			Map<String, Object> model) {

		List<Report> results = this.redisService.retriveFinancialReport(
				getLoginEmail(), searchReportVo);

		model.put("selections", results);
		return "report/reportHistory";

	}
}
