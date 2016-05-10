package com.rainasmoon.onepay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.util.CommonUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public boolean checkUserIfExists(String loginName) {

		return userRepository.findByEmailOrPhone(loginName) != null ? true
				: false;
	}

	@Override
	@Transactional(readOnly = true)
	public User login(String loginName, String password) {
		User loginUser = userRepository.findByEmailOrPhone(loginName);
		return loginUser.getPassword().equals(password) ? loginUser : null;
	}

	@Override
	@Transactional
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

	@Override
	@Transactional(readOnly = true)
	public List<User> listActiveTop5Users() {
		Iterable<User> users = userRepository.findAll();
		List<User> result = new ArrayList<User>();
		for (User u : users) {
			result.add(u);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public User findUser(Long userId) {

		return userRepository.findOne(userId);
	}

	@Override
	@Transactional
	public User updateUser(User user) {

		return userRepository.save(user);
	}

}
