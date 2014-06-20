package com.hawk.mgc.web;

import org.springframework.validation.Errors;

import com.hawk.mgc.model.User;
import com.hawk.mgc.service.UserService;

public class CreateUserValidator {

	private UserService userService;

	public CreateUserValidator(UserService userService) {
		super();
		this.userService = userService;
	}

	public void validate(User user, Errors errors) {

		if (user.getUserName() != null
				&& userService.isUserNameExists(user.getUserName())) {
			errors.rejectValue("userName", "error.userName.duplicated");
		}

	}

}
