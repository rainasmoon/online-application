package com.hawk.mgc.web;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.mgc.model.User;
import com.hawk.mgc.service.UserService;

@Controller
@SessionAttributes(types = User.class)
public class UserController {

	Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("roleTypes")
	public List<String> populateContactTypes() {
		return Arrays.asList("manager", "user");
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String processFindAll(Map<String, Object> model) {

		List<User> results = this.userService.findAllUsers();

		model.put("selections", results);
		return "user/listUser";

	}

	@RequestMapping(value = "/users/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		User user = new User();
		model.put("user", user);

		return "user/createOrUpdateUser";
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid User user, BindingResult result) {
		new CreateUserValidator(userService).validate(user, result);
		if (result.hasErrors()) {
			return "user/createOrUpdateUser";
		} else {
			this.userService.saveUser(user);
			return "redirect:/users";
		}
	}

	@RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
	public String initUpdateForm(@PathVariable("userId") int userId,
			Map<String, Object> model) {
		User user = userService.findUserById(userId);
		model.put("user", user);

		return "user/createOrUpdateUser";
	}

	@RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.POST)
	public String processUpdateForm(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user/createOrUpdateUser";
		} else {
			this.userService.saveUser(user);
			return "redirect:/users";
		}
	}

	@RequestMapping(value = "/users/{userId}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") int userId,
			Map<String, Object> model) {

		this.userService.deleteUserById(userId);

		return processFindAll(model);
	}

}
