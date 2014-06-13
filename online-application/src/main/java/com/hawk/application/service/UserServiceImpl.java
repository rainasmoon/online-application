package com.hawk.application.service;

import java.util.List;

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
	public List<User> findAllUsers() {

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
	public boolean changePassword(String userEmail,
			ChangePasswordVo changePasswordVo) {
		User loginUser = userRepository.findByEmail(userEmail);
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

	@Override
	public User findUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}

}
