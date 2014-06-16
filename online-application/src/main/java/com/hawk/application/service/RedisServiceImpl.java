package com.hawk.application.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hawk.application.model.Report;
import com.hawk.application.model.SearchReportVo;
import com.hawk.application.model.WelcomeVo;
import com.hawk.application.repository.redis.RedisRepository;

@Service
public class RedisServiceImpl implements RedisService {

	Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);

	private static final String TEST_DIANJOY_APP_ID = "TEST_DIANJOY_APP_ID";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyyMMdd");

	private RedisRepository redisRepository;

	@Autowired
	public RedisServiceImpl(RedisRepository redisRepository) {
		this.redisRepository = redisRepository;
	}

	public WelcomeVo retriveWelcomeInfo() {
		// TODO Auto-generated method stub
		// find the user's all applications.
		// find each applications's today's income.
		// add them together.
		WelcomeVo welcomeVo = new WelcomeVo();
		String todayStr = DATE_FORMAT.format(new Date());
		String id = TEST_DIANJOY_APP_ID + "_" + todayStr + "_" + "total";
		// redisRepository.setValue(id, "128");
		// String todayIncomeStr = redisRepository.getValue(id);
		String todayIncomeStr = "123.4";
		LOGGER.debug(":www: today's income:" + id);
		LOGGER.debug(":www: today's income:" + todayIncomeStr);

		if (todayIncomeStr != null) {
			welcomeVo.setTodayIncome(Double.parseDouble(todayIncomeStr));
		}
		welcomeVo.setTodayPromotedUsers(100);
		welcomeVo.setTodayUsers(50);
		welcomeVo.setTotalBanlance(10000);
		welcomeVo.setYesterdayIncome(900);
		welcomeVo.setYesterdayPromotedUsers(80);
		welcomeVo.setYesterdayUsers(70);

		welcomeVo.setPromotedUsersTrendArrayString("[[1, 2],[3, 4]]");
		welcomeVo.setPromotedIncomeTrendArrayString("[[1, 1],[3, 2]]");

		return welcomeVo;
	}

	@Override
	public List<Report> retriveFinancialReport(SearchReportVo searchReportVo) {
		LOGGER.debug("Search critire: " + searchReportVo.toString());
		List<Report> l = new ArrayList<Report>();
		Report report = new Report();
		report.setDate(new Date());
		report.setNewUsers(30);
		report.setActiveUsers(90);
		report.setActvation(127);
		report.setActvationIncome(500.0);
		report.setTaskIncome(20.0);
		report.setPromoteIncome(1000.0);

		l.add(report);
		return l;
	}
}
