package com.hawk.application.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.hawk.application.model.ChangePasswordVo;
import com.hawk.application.model.LoginVo;
import com.hawk.application.model.User;
import com.hawk.application.service.UserService;

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

	@RequestMapping(value = { "/users/new", "/register" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		User user = new User();
		model.put("user", user);
		return "user/register";
	}

	@RequestMapping(value = { "/users/new", "/register" }, method = RequestMethod.POST)
	public String processCreationForm(@Valid User user, BindingResult result) {
		new RegisterValidator(userService).validate(user, result);
		if (result.hasErrors()) {
			return "user/register";
		} else {
			this.userService.saveUser(user);
//			status.setComplete();
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String initLoginForm(Map<String, Object> model) {
		LoginVo loginVo = new LoginVo();
		model.put("loginVo", loginVo);
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(@Valid LoginVo loginVo,
			BindingResult result, HttpServletRequest request,
			HttpSession session, Map<String, Object> model) {
		new LoginValidator().validate(request, loginVo, result);
		if (result.hasErrors()) {			
			LOGGER.debug("Login has error.");
			return "user/login";
		} else {

			User user = userService.login(loginVo);

			if (user == null) {
				result.rejectValue("error", "error.userNameOrPassword.invalid");
				LOGGER.warn("login failed. with no user in db." );
				return "user/login";
			}
			
			session.setAttribute("userEmail", user.getEmail());
			LOGGER.debug("Session ID:" + session.getId());
			LOGGER.debug("Set User in session:" + user);			
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		LOGGER.debug("Logout running...");
		LOGGER.debug("Session ID:" + session.getId());		
		session.removeAttribute("userEmail");
		session.invalidate();
		return "redirect:/";
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
					(String) session.getAttribute("userEmail"), changePasswordVo)) {
				result.rejectValue("error", "error.passwordChange.failed");
				return "user/changePassword";
			}			
			return "redirect:/";
		}
	}

}
