package com.hawk.application.service;

import java.util.Collection;

import com.hawk.application.model.ChangePasswordVo;
import com.hawk.application.model.LoginVo;
import com.hawk.application.model.User;

public interface UserService {

	void saveUser(User user);

	Collection<User> findAllUsers();

	User login(LoginVo loginVo);

	boolean changePassword(User user, ChangePasswordVo changePasswordVo);

}
