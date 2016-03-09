package com.rainasmoon.onepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.util.CommonUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean checkUserIfExists(String loginName) {

		return userRepository.findByEmailOrPhone(loginName) != null ? true : false;
	}

	@Override
	public User login(String loginName, String password) {
		User loginUser = userRepository.findByEmailOrPhone(loginName);
		return loginUser.getPassword().equals(password) ? loginUser : null;
	}

	@Override
	public User addUser(String loginName, String password) {
		User user = new User();
		if (CommonUtils.isEmail(loginName)) {
			user.setEmail(loginName);
		} else {
			user.setPhone(loginName);
		}

		user.setPassword(password);

		return userRepository.save(user);
	}

}
