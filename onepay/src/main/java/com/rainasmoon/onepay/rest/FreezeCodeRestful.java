package com.rainasmoon.onepay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.service.UserService;

@RestController
@RequestMapping(produces = "text/plain;charset=UTF-8")
public class FreezeCodeRestful {
	@Autowired
	private UserService userService;

	@RequestMapping("restful/verifyFreezeCode")
	public String verifyFreezeCode(
			@RequestParam(value = "freezeCode") String freezeCode) {

		User user = userService.findUser(1L);
		user = user.unfreeze(100);
		userService.updateUser(user);
		return "developing. pls send email to admin";
	}
}
