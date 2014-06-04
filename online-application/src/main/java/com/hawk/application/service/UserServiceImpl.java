/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hawk.application.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hawk.application.model.ChangePasswordVo;
import com.hawk.application.model.LoginVo;
import com.hawk.application.model.User;
import com.hawk.application.repository.springdatajpa.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	@Transactional
	public void saveUser(User user) throws DataAccessException {
		userRepository.save(user);

	}

	@Transactional(readOnly = true)
	public Collection<User> findAllUsers() {

		return userRepository.findAll();
	}

	@Transactional(readOnly = true)
	public User login(LoginVo loginVo) {
		User user = userRepository.findByEmail(loginVo.getEmail());

		if (user != null && loginVo.getPassword().equals(user.getPassword())) {
			return user;
		}

		return null;
	}

	@Transactional
	public boolean changePassword(User loginUser,
			ChangePasswordVo changePasswordVo) {
		if (loginUser.getPassword().equals(changePasswordVo.getOldPassword())
				&& changePasswordVo.getNewPassword().equals(
						changePasswordVo.getConfirmPassword())) {

			userRepository.updatePassword(loginUser.getId(),
					changePasswordVo.getNewPassword());
			return true;
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isEmailExists(String email) {
		User user = userRepository.findByEmail(email);
		return user != null;
	}
}
