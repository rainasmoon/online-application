package com.hawk.mgc.service;

import com.hawk.mgc.model.LoginVo;
import com.hawk.mgc.model.User;

public interface UserService {

	void saveUser(User user);

	User login(LoginVo loginVo);

	User findUserByUserName(String userName);

	boolean isUserNameExists(String userName);

}
