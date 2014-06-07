package com.hawk.application.service;

import java.util.Collection;

import com.hawk.application.model.Bonus;
import com.hawk.application.model.Check;

public interface FinanceService {

	void saveCheck(Check check);

	Collection<Check> findAllChecks();

	Collection<Bonus> findAllBonus();

}
