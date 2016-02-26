package com.rainasmoon.onepay.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.model.User;

@Controller
@SessionAttributes(types = User.class)
@PropertySource("classpath:/spring/data-access.properties")
public class UserViewController {

	Logger LOGGER = LoggerFactory.getLogger(UserViewController.class);
	private final UserService userService;

	@Autowired
	public UserViewController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/viewMe", method = RequestMethod.GET)
	public ModelAndView viewMe(HttpSession session) {
		ModelAndView mav = new ModelAndView("user/view");
		String userEmail = (String) session.getAttribute("userEmail");
		User user = userService.findUserByEmail(userEmail);
		LOGGER.debug("view User:" + user);

		mav.addObject(user);
		return mav;
	}

}
