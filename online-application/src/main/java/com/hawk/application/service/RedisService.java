package com.hawk.application.service;

import java.util.List;

import com.hawk.application.model.*;


public interface RedisService {

	WelcomeVo retriveWelcomeInfo();
	
	List<Report> retriveFinancialReport();
}
