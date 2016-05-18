package com.rainasmoon.onepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainasmoon.onepay.model.ResetPasswordApplication;
import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.repository.springdatajpa.ResetPasswordApplicationRepository;
import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.service.ResetPasswordService;
import com.rainasmoon.onepay.util.CommonConstants;
import com.rainasmoon.onepay.util.EmailUtils;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

	@Autowired
	private ResetPasswordApplicationRepository resetPasswordApplicationRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public String addApplication(ResetPasswordApplication application) {
		resetPasswordApplicationRepository.save(application);

		User user = userRepository.findByEmailOrPhone(application.getLoginAccount());

		if (user != null) {

			// TODO glen
			String code = user.getId().toString();

			EmailUtils.sendEmail("重置密码", "重置密码，请点击：" + CommonConstants.BASE_URL + "/reset_password_reset.html?code=" + code, application.getReceiveResetEmail());

		}

		return "存储成功";
	}

}
