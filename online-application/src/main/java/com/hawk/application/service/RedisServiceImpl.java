package com.hawk.application.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hawk.application.model.Application;
import com.hawk.application.model.Report;
import com.hawk.application.model.SearchReportVo;
import com.hawk.application.model.WelcomeVo;
import com.hawk.application.repository.redis.RedisRepository;
import com.hawk.application.repository.springdatajpa.ApplicationRepository;
import com.hawk.application.repository.springdatajpa.UserRepository;
import com.hawk.application.util.DayBuilder;

@Service
public class RedisServiceImpl implements RedisService {

	Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);

	private RedisRepository redisRepository;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	public RedisServiceImpl(RedisRepository redisRepository) {
		this.redisRepository = redisRepository;
	}

	public WelcomeVo retriveWelcomeInfo(String email) {
		WelcomeVo welcomeVo = new WelcomeVo();
		DayBuilder dayBuilder = new DayBuilder();

		Integer userId = userRepository.findByEmail(email).getId();
		LOGGER.debug("user id is:" + userId);
		List<Application> myApplications = applicationRepository
				.findByCreatedBy(userId);
		LOGGER.debug("the apps is:" + myApplications);
		welcomeVo.setTodayIncome(retriveDayIncome(myApplications,
				dayBuilder.getToday()));

		welcomeVo.setTodayPromotedUsers(retriveDayPromotedUsers(myApplications,
				dayBuilder.getToday()));
		welcomeVo.setTodayUsers(retriveDayUsers(myApplications,
				dayBuilder.getToday()));

		welcomeVo.setTotalBanlance(retriveUserTotalIncome(userId));

		welcomeVo.setYesterdayIncome(retriveDayIncome(myApplications,
				dayBuilder.getYesterday()));
		welcomeVo.setYesterdayPromotedUsers(retriveDayPromotedUsers(
				myApplications, dayBuilder.getYesterday()));
		welcomeVo.setYesterdayUsers(retriveDayUsers(myApplications,
				dayBuilder.getYesterday()));

		welcomeVo
				.setPromotedIncomeTrendArrayString(generatePromotedIncomeTrendArrayString(
						myApplications, dayBuilder.getLastMonthToday(),
						dayBuilder.getToday()));
		welcomeVo
				.setPromotedUsersTrendArrayString(generatePromotedUsersTrendArrayString(
						myApplications, dayBuilder.getLastMonthToday(),
						dayBuilder.getToday()));

		return welcomeVo;
	}

	private String generatePromotedUsersTrendArrayString(
			List<Application> myApplications, Date lastMonthDay, Date today) {

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Date day = lastMonthDay; day.before(today); day = new Date(
				day.getTime() + 24 * 3600 * 1000)) {
			int value = retriveDayPromotedUsers(myApplications, day);
			sb.append("[" + day.getTime() + "," + value + "]");
			if (new Date(day.getTime() + 24 * 3600 * 1000).before(today)) {
				sb.append(", ");
			}
		}
		sb.append("]");

		return sb.toString();
	}

	private String generatePromotedIncomeTrendArrayString(
			List<Application> myApplications, Date lastMonthDay, Date today) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Date day = lastMonthDay; day.before(today); day = new Date(
				day.getTime() + 24 * 3600 * 1000)) {
			double value = retriveDayIncome(myApplications, day);
			sb.append("[" + day.getTime() + "," + value + "]");
			if (new Date(day.getTime() + 24 * 3600 * 1000).before(today)) {
				sb.append(", ");
			}
		}
		sb.append("]");

		return sb.toString();
	}

	private int retriveDayUsers(List<Application> myApplications, Date day) {
		int r = 0;
		for (Application app : myApplications) {
			String key = RedisKeyUtils.getAppDayNewUsers(app.getDianjoyAppId(),
					day);
			Integer temp = redisRepository.getValueAsInteger(key);
			if (temp == null) {
				LOGGER.warn("there is no date in redis for key: " + key);
				temp = 0;
			}
			r += temp;
		}
		return r;
	}

	private int retriveDayPromotedUsers(List<Application> myApplications,
			Date day) {
		int r = 0;
		for (Application app : myApplications) {
			String key = RedisKeyUtils.getAppDayPromotions(
					app.getDianjoyAppId(), day);
			Integer temp = redisRepository.getValueAsInteger(key);
			if (temp == null) {
				LOGGER.warn("there is no date in redis for key: " + key);
				temp = 0;
			}
			r += temp;
		}
		return r;

	}

	private double retriveUserTotalIncome(Integer userId) {
		String key = RedisKeyUtils.getUserTotalIncome(userId);
		Double r = redisRepository.getValueAsDouble(key);
		if (r == null) {
			LOGGER.warn("there is no date in redis for key: " + key);
			r = 0.0;
		}
		return r;
	}

	private double retriveDayIncome(List<Application> myApplications, Date day) {
		int r = 0;
		for (Application app : myApplications) {
			String key = RedisKeyUtils.getAppDayNewUsers(app.getDianjoyAppId(),
					day);
			Integer temp = redisRepository.getValueAsInteger(key);
			if (temp == null) {
				LOGGER.warn("there is no date in redis for key: " + key);
				temp = 0;
			}
			r += temp;
		}
		return r;
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
