package com.hawk.application.web;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hawk.application.model.ChangePasswordVo;
import com.hawk.application.service.UserService;

@Controller
public class UserChangePasswordController {

	Logger LOGGER = LoggerFactory.getLogger(UserChangePasswordController.class);
	private final UserService userService;

	@Autowired
	public UserChangePasswordController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String initChangePasswordForm(Map<String, Object> model) {

		ChangePasswordVo changePasswordVo = new ChangePasswordVo();
		model.put("changePasswordVo", changePasswordVo);

		return "user/changePassword";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String processChangePasswordForm(
			@Valid ChangePasswordVo changePasswordVo, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "user/changePassword";
		} else {

			if (!userService.changePassword(
					(String) session.getAttribute("userEmail"),
					changePasswordVo)) {
				result.rejectValue("error", "error.passwordChange.failed");
				return "user/changePassword";
			}
			return "redirect:/";
		}
	}

}
