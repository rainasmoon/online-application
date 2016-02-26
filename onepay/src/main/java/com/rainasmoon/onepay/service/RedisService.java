package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Report;
import com.rainasmoon.onepay.model.SearchReportVo;
import com.rainasmoon.onepay.model.WelcomeVo;

public interface RedisService {

	WelcomeVo retriveWelcomeInfo(String email);

	List<Report> retriveFinancialReport(String email,
			SearchReportVo searchReportVo);

	double getUserTotalIncome(String email);
}
