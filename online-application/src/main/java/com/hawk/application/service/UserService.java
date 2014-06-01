package com.hawk.application.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.hawk.application.model.User;

public interface UserService {

	void saveUser(User user) throws DataAccessException;

	Collection<User> findAllUsers();

}
