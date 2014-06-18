package com.hawk.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hawk.application.model.Bonus;
import com.hawk.application.model.Check;
import com.hawk.application.repository.springdatajpa.BonusRepository;
import com.hawk.application.repository.springdatajpa.CheckRepository;
import com.hawk.application.repository.springdatajpa.UserRepository;

@Service
public class FinanceServiceImpl implements FinanceService {

	@Autowired
	private CheckRepository checkRepository;

	@Autowired
	private BonusRepository bonusRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveCheck(String email, Check check) {
		Integer createdBy = userRepository.findByEmail(email).getCreatedBy();
		check.setCreatedBy(createdBy);
		check.setUpdatedBy(createdBy);
		checkRepository.save(check);
	}

	@Override
	public List<Check> findAllChecks(String email) {
		Integer createdBy = userRepository.findByEmail(email).getCreatedBy();
		return checkRepository.findByCreatedBy(createdBy);
	}

	@Override
	public List<Bonus> findAllBonus(String email) {
		Integer createdBy = userRepository.findByEmail(email).getCreatedBy();
		return bonusRepository.findByCreatedBy(createdBy);
	}

}
