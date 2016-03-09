package com.rainasmoon.onepay.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.vo.LoginVo;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login.html" }, method = RequestMethod.GET)
	public String login(Map<String, Object> model) {

		LoginVo loginVo = new LoginVo();
		model.put("loginVo", loginVo);

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(@Valid LoginVo loginVo, BindingResult result, HttpServletRequest request, HttpSession session, Map<String, Object> model) {

		LOGGER.debug("Session:www:" + loginVo);

		// if exist -> login. else create
		// 1 check if userAccount exist. yes -> check password. no -> ask user what to do... create or relogin.
		if (userService.checkUserIfExists(loginVo.getAccount())) {
			User loginUser = userService.login(loginVo.getAccount(), loginVo.getPassword());
			if (loginUser != null) {
				// login success
				session.setAttribute("userId", loginUser.getId());
				return "redirect:/";
			} else {
				// account or password wrong...
				result.rejectValue("error", "error.userNameOrPassword.invalid");
				LOGGER.warn("login failed. with no user in db.");
				model.put("loginVo", loginVo);
				return "login";
			}
		} else {
			// ask if create a new user or relogin.
			if (StringUtils.isBlank(loginVo.getConfirmPassword())) {
				model.put("message", "账号不存在，是否创建？");
				model.put("loginVo", loginVo);
				return "login_register";
			} else {
				if (!loginVo.getConfirmPassword().equals(loginVo.getPassword())) {
					result.rejectValue("error", "error.confirmPassword.invalid");
					model.put("loginVo", loginVo);
					return "login_register";
				} else {
					userService.addUser(loginVo.getAccount(), loginVo.getPassword());
					model.put("message", "创建账号成功");
					model.put("loginVo", loginVo);
					return "login_register_success";
				}
			}
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		LOGGER.debug("Logout running...");
		LOGGER.debug("Session ID:" + session.getId());
		session.removeAttribute("userId");
		session.invalidate();
		return "redirect:/";
	}
}
