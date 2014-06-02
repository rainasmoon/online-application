package com.hawk.application.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		redisRepository.setValue(id, "128");
		String todayIncomeStr = redisRepository.getValue(id);
		LOGGER.debug(":www: today's income:" + id);
		LOGGER.debug(":www: today's income:" + todayIncomeStr);

		if (todayIncomeStr != null) {
			welcomeVo.setTodayIncome(Double.parseDouble(todayIncomeStr));
		}

		return welcomeVo;
	}
}
