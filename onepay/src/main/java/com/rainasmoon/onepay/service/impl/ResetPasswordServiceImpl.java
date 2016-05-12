package com.rainasmoon.onepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainasmoon.onepay.model.ResetPasswordApplication;
import com.rainasmoon.onepay.repository.springdatajpa.ResetPasswordApplicationRepository;
import com.rainasmoon.onepay.service.ResetPasswordService;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

	@Autowired
	private ResetPasswordApplicationRepository resetPasswordApplicationRepository;

	@Override
	@Transactional
	public String addApplication(ResetPasswordApplication application) {
		resetPasswordApplicationRepository.save(application);
		return "存储成功";
	}

}
