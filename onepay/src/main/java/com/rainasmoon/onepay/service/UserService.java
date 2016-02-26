package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.model.ChangePasswordVo;
import com.rainasmoon.onepay.model.LoginVo;
import com.rainasmoon.onepay.model.User;

public interface UserService {

	void saveUser(User user);

	void saveUser(String email, User user);

	User login(LoginVo loginVo);

	User findUserByEmail(String email);

	boolean changePassword(String userEmail, ChangePasswordVo changePasswordVo);

	boolean isEmailExists(String email);

}
