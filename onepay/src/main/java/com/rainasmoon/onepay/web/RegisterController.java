package com.rainasmoon.onepay.web;

import java.util.Map;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.model.RegistorVo;
import com.rainasmoon.onepay.model.User;

@Controller
public class RegisterController {

	Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private Mapper dozerBeanMapper;

	@RequestMapping(value = { "/users/new", "/register" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		RegistorVo registorVo = new RegistorVo();
		model.put("registorVo", registorVo);
		return "user/register";
	}

	@RequestMapping(value = { "/users/new", "/register" }, method = RequestMethod.POST)
	public String processCreationForm(@Valid RegistorVo registorVo,
			BindingResult result) {
		new RegisterValidator(userService).validate(registorVo, result);
		if (result.hasErrors()) {
			return "user/register";
		} else {
			User user = dozerBeanMapper.map(registorVo, User.class);
			this.userService.saveUser(user);
			return "redirect:/";
		}
	}
}
