package com.rainasmoon.onepay.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainasmoon.onepay.model.User;

public class LoginServiceTest extends BaseTest {

	@Autowired
	UserService loginService;

	@Test
	public void shouldAddUserByEmail() {
		User user = loginService.addUser("testUser@my.home", "testPassword");

		assertNotNull(user);
		assertNotNull(user.getId());
		assertEquals("testUser@my.home", user.getEmail());
	}

	@Test
	public void shouldAddUserByPhone() {
		User user = loginService.addUser("15812345555", "testPassword");

		assertNotNull(user);
		assertNotNull(user.getId());
		assertEquals("15812345555", user.getPhone());
	}
}
