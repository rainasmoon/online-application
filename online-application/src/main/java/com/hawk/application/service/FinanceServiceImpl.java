package com.hawk.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hawk.application.model.Bonus;
import com.hawk.application.model.Check;
import com.hawk.application.repository.springdatajpa.*;

@Service
public class FinanceServiceImpl implements FinanceService {

	@Autowired
	private CheckRepository checkRepository;
	
	@Autowired
	private BonusRepository bonusRepository;
	
	@Override
	public void saveCheck(Check check) {
		checkRepository.save(check);		
	}

	@Override
	public List<Check> findAllChecks() {		
		return checkRepository.findAll();
	}

	@Override
	public List<Bonus> findAllBonus() {		
		return bonusRepository.findAll();
	}

}
