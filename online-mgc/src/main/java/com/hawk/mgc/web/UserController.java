package com.hawk.mgc.web;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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

}
