package com.hawk.application.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.hawk.application.model.RegistorVo;
import com.hawk.application.model.User;
import com.hawk.application.service.UserService;


public class RegisterValidator {
	
	private UserService userService;
		
	public RegisterValidator(UserService userService) {
		super();
		this.userService = userService;
	}

	public void validate(RegistorVo user, Errors errors) {
		String email = user.getEmail();
		// name validaation
		if (!StringUtils.hasLength(email)) {
			errors.rejectValue("email", "required", "required");
		}
		
		if (userService.isEmailExists(email)) {
			errors.rejectValue("email", "error.email.duplicated");
		}
		
		if (!user.getConfirmPassword().equals(user.getPassword())){
			errors.rejectValue("confirmPassword", "error.confirmpassword.invalid");
		}

	}

}
