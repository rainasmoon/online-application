package com.hawk.application.service;

import java.util.List;

import com.hawk.application.model.ChangePasswordVo;
import com.hawk.application.model.LoginVo;
import com.hawk.application.model.User;

public interface UserService {

	void saveUser(User user);

	List<User> findAllUsers();

	User login(LoginVo loginVo);
	
	User findUserByEmail(String email);

	boolean changePassword(String userEmail, ChangePasswordVo changePasswordVo);

	boolean isEmailExists(String email);

}
