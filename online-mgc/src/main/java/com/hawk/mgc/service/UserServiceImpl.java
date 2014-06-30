package com.hawk.mgc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hawk.mgc.model.LoginVo;
import com.hawk.mgc.model.User;
import com.hawk.mgc.repository.springdatajpa.UserRepository;

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

	@Transactional
	public User login(LoginVo loginVo) {
		User user = userRepository.findByUserName(loginVo.getUserName());

		if (user != null) {
			if (loginVo.getPassword().equals(user.getPassword())) {
				return user;
			} else {
				if (user.isManager()) {
					user.addFailedTimes();
					if (user.getFailTimes() >= 2) {
						user.lock();
					}
					userRepository.save(user);
				}
			}

		}

		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isUserNameExists(String userName) {
		User user = userRepository.findByUserName(userName);
		return user != null;
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserByUserName(String userName) {

		return userRepository.findByUserName(userName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAllUsers() {

		return userRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteUserById(int userId) {
		userRepository.delete(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserById(int userId) {
		return userRepository.findOne(userId);
	}

}
