package com.hawk.application.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RedisKeyUtils {

	public static final String TEST_DIANJOY_APP_ID = "TEST_DIANJOY_APP_ID";
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyyMMdd");

	public static String getAppTotolIncome(String appId) {
		return appId + "_total";
	}

	public static String getAppDayIncome(String appId, Date day) {
		return appId + "_" + DATE_FORMAT.format(day) + "_total";
	}

	public static String getAppDayPromotions(String appId, Date day) {
		return appId + "_" + DATE_FORMAT.format(day) + "_total_promotion";
	}

	public static String getAppDayNewUsers(String appId, Date day) {
		return appId + "_" + DATE_FORMAT.format(day) + "_total_user";
	}

	public static String getAppDayActiveUsers(String appId, Date day) {
		return appId + "_" + DATE_FORMAT.format(day) + "_active_user";
	}

	public static String getAppDayActivation(String appId, Date day) {
		return appId + "_" + DATE_FORMAT.format(day) + "_actviation";
	}

	public static String getAppDayActivationIncome(String appId, Date day) {
		return appId + "_" + DATE_FORMAT.format(day) + "_activation_income";
	}

	public static String getAppDayTaskIncome(String appId, Date day) {
		return appId + "_" + DATE_FORMAT.format(day) + "_task_income";
	}

	public static String getUserTotalIncome(Integer userId) {

		if (userId == null) {
			throw new KeyGenerateException("userId is null.");
		}
		return userId + "_total";
	}

}
