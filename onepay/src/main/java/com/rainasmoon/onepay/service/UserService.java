package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.model.User;

public interface UserService {

	boolean checkUserIfExists(String loginName);

	User login(String loginName, String password);

	User addUser(String loginName, String password);
}
