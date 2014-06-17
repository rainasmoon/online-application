package com.hawk.application.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
		String todayIncomeStr = redisRepository.getValue(RedisKeyUtils
				.getAppTodayIncome(RedisKeyUtils.TEST_DIANJOY_APP_ID));
		LOGGER.debug(":www: today's id:"
				+ RedisKeyUtils
						.getAppTodayIncome(RedisKeyUtils.TEST_DIANJOY_APP_ID));
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

		long today = new Date().getTime();
		long aday = 24 * 3600 * 1000;

		Random rand = new Random();

		String s = "[";
		for (int i = 0; i < 30; i++) {
			s += "[" + (today - (30 - i) * aday) + ", "
					+ (rand.nextInt(100) + 20) + "], ";
		}
		s += "[" + today + ", " + (rand.nextInt(100) + 20) + "]]";

		String ss = "[";
		for (int i = 0; i < 30; i++) {
			ss += "[" + (today - (30 - i) * aday) + ", "
					+ (rand.nextDouble() * 10 + 10) + "], ";
		}
		ss += "[" + today + ", " + (rand.nextDouble() * 10 + 10) + "]]";

		welcomeVo.setPromotedUsersTrendArrayString(s);
		welcomeVo.setPromotedIncomeTrendArrayString(ss);

		return welcomeVo;
	}

	@Override
	public List<Report> retriveFinancialReport(SearchReportVo searchReportVo) {
		LOGGER.debug("Search critire: " + searchReportVo.toString());
		// TODO: need to get a total amount.

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
