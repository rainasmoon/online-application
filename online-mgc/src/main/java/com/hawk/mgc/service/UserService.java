package com.hawk.mgc.service;

import java.util.List;

import com.hawk.mgc.model.LoginVo;
import com.hawk.mgc.model.User;

public interface UserService {

	void saveUser(User user);

	User login(LoginVo loginVo);

	User findUserByUserName(String userName);

	List<User> findAllUsers();

	boolean isUserNameExists(String userName);

	void deleteUserById(int userId);

	User findUserById(int userId);

}
