package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.User;

public interface UserService {

	boolean checkUserIfExists(String loginName);

	User login(String loginName, String password);

	User addUser(String loginName, String password);

	List<User> listActiveTop5Users();

	User findUser(Long userId);
}
