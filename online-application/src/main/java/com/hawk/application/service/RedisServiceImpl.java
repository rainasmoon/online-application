package com.hawk.application.service;

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
import com.hawk.application.util.DayBuilder;

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

		DayBuilder dayBuilder = new DayBuilder();

		welcomeVo.setTodayIncome(redisRepository.getValueAsDouble(RedisKeyUtils
				.getAppDayIncome(RedisKeyUtils.TEST_DIANJOY_APP_ID,
						dayBuilder.getToday())));

		welcomeVo.setTodayPromotedUsers(redisRepository
				.getValueAsInteger(RedisKeyUtils.getAppDayPromotions(
						RedisKeyUtils.TEST_DIANJOY_APP_ID,
						dayBuilder.getToday())));
		welcomeVo.setTodayUsers(redisRepository.getValueAsInteger(RedisKeyUtils
				.getAppDayNewUsers(RedisKeyUtils.TEST_DIANJOY_APP_ID,
						dayBuilder.getToday())));
		welcomeVo.setTotalBanlance(redisRepository
				.getValueAsDouble(RedisKeyUtils
						.getAppTotolIncome(RedisKeyUtils.TEST_DIANJOY_APP_ID)));
		welcomeVo.setYesterdayIncome(redisRepository
				.getValueAsDouble(RedisKeyUtils.getAppDayIncome(
						RedisKeyUtils.TEST_DIANJOY_APP_ID,
						dayBuilder.getYesterday())));
		welcomeVo.setYesterdayPromotedUsers(redisRepository
				.getValueAsInteger(RedisKeyUtils.getAppDayIncome(
						RedisKeyUtils.TEST_DIANJOY_APP_ID,
						dayBuilder.getYesterday())));
		welcomeVo.setYesterdayUsers(redisRepository
				.getValueAsInteger(RedisKeyUtils.getAppDayIncome(
						RedisKeyUtils.TEST_DIANJOY_APP_ID,
						dayBuilder.getYesterday())));

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
		report.setActvation(null);
		report.setActvationIncome(null);
		report.setTaskIncome(20.0);
		report.setPromoteIncome(1000.0);

		l.add(report);
		return l;
	}
}
