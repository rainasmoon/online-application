package com.hawk.application.service;

import java.util.List;

import com.hawk.application.model.Report;
import com.hawk.application.model.SearchReportVo;
import com.hawk.application.model.WelcomeVo;

public interface RedisService {

	WelcomeVo retriveWelcomeInfo();

	List<Report> retriveFinancialReport(SearchReportVo searchReportVo);
}
