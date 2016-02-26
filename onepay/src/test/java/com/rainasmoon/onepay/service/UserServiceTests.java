package com.rainasmoon.onepay.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.model.ChangePasswordVo;
import com.rainasmoon.onepay.model.User;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class UserServiceTests {

	@Autowired
	protected UserService userService;

	@Autowired
	protected UserRepository userRepository;

	@Test
	public void shouldChangePassword() {

		User user = new User();
		user.setEmail("test@t.t");
		user.setPassword("old");
		userRepository.save(user);

		ChangePasswordVo changePasswordVo = new ChangePasswordVo();
		changePasswordVo.setOldPassword("old");
		changePasswordVo.setNewPassword("new");
		changePasswordVo.setConfirmPassword("new");

		userService.changePassword(user.getEmail(), changePasswordVo);

		user = userRepository.findOne(user.getId());

		assertEquals("new", user.getPassword());
	}
}