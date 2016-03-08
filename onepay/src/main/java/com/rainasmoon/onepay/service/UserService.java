package com.rainasmoon.onepay.service;

public interface UserService {

	boolean checkUserIfExists(String loginName);

	boolean checkLogin(String loginName, String password);

	void addUser(String loginName, String password);
}
