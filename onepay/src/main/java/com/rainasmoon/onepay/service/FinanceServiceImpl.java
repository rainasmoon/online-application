package com.rainasmoon.onepay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.repository.springdatajpa.BonusRepository;
import com.rainasmoon.onepay.repository.springdatajpa.CheckRepository;
import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.model.Bonus;
import com.rainasmoon.onepay.model.Check;

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
		Integer createdBy = userRepository.findByEmail(email).getId();
		check.setCreatedBy(createdBy);
		check.setUpdatedBy(createdBy);
		checkRepository.save(check);
	}

	@Override
	public List<Check> findAllChecks(String email) {
		Integer createdBy = userRepository.findByEmail(email).getId();
		return checkRepository.findByCreatedBy(createdBy);
	}

	@Override
	public List<Bonus> findAllBonus(String email) {
		Integer createdBy = userRepository.findByEmail(email).getId();
		return bonusRepository.findByCreatedBy(createdBy);
	}

}
