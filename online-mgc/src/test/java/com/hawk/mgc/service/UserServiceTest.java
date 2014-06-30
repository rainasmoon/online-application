package com.hawk.mgc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hawk.mgc.model.LoginVo;
import com.hawk.mgc.model.User;
import com.hawk.mgc.repository.springdatajpa.PackageDetailRepositoryTests;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class UserServiceTest {

	Logger LOGGER = LoggerFactory.getLogger(PackageDetailRepositoryTests.class);

	@Autowired
	private UserService userService;

	private LoginVo loginVo;

	@Test
	public void shouldLoginManagerSuccessful() {
		givenAsavedUser();
		loginVo = new LoginVo();
		loginVo.setUserName("testmanager");
		loginVo.setPassword("123");
		User user = userService.login(loginVo);
		assertNotNull(user);
		assertEquals("testmanager", user.getUserName());

		loginVo = new LoginVo();
		loginVo.setUserName("testuser");
		loginVo.setPassword("123");
		user = userService.login(loginVo);
		assertNotNull(user);
		assertEquals("testuser", user.getUserName());

		loginVo = new LoginVo();
		loginVo.setUserName("testmanager");
		loginVo.setPassword("1234");
		user = userService.login(loginVo);
		user = userService.login(loginVo);
		assertNull(user);
		user = userService.findUserByUserName("testmanager");
		assertTrue(user.isLocked());

		loginVo = new LoginVo();
		loginVo.setUserName("testuser");
		loginVo.setPassword("1234");
		user = userService.login(loginVo);
		user = userService.login(loginVo);
		assertNull(user);
		user = userService.findUserByUserName("testuser");
		assertFalse(user.isLocked());

	}

	private void givenAsavedUser() {
		User user = new User();
		user.setUserName("testmanager");
		user.setPassword("123");
		user.setUserRole("manager");
		userService.saveUser(user);

		user = new User();

		user.setUserName("testuser");
		user.setPassword("123");
		user.setUserRole("user");
		userService.saveUser(user);

	}

}
