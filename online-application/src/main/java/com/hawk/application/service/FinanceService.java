package com.hawk.application.service;

import java.util.List;

import com.hawk.application.model.Bonus;
import com.hawk.application.model.Check;

public interface FinanceService {

	void saveCheck(String email, Check check);

	List<Check> findAllChecks(String email);

	List<Bonus> findAllBonus(String email);

}
