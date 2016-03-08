package com.rainasmoon.onepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean checkUserIfExists(String loginName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkLogin(String loginName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addUser(String loginName, String password) {
		// TODO Auto-generated method stub

	}

}
