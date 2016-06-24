package com.rainasmoon.onepay.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	public static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login.html" }, method = RequestMethod.GET)
	public String login(String toUrl, Map<String, Object> model) {

		LoginVo loginVo = new LoginVo();
		loginVo.setToUrl(toUrl);
		model.put("loginVo", loginVo);

		return "login";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)	
	public String processLoginForm(LoginVo loginVo, String rememberMe, BindingResult result, HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {

		LOGGER.debug("Session:www:" + loginVo);
		LOGGER.warn("Session:www:" + rememberMe);

		
		if (StringUtils.isBlank(loginVo.getAccount())) {
			result.rejectValue("account", "NotEmpty.loginVo.account");
		}
		
		if (StringUtils.isBlank(loginVo.getAccount())) {
			result.rejectValue("password", "NotEmpty.loginVo.password");
		}
		
		if (result.hasErrors()) {
			LOGGER.warn("Login has error.");
			return "login";
		}
	
		// if exist -> login. else create
		// 1 check if userAccount exist. yes -> check password. no -> ask user
		// what to do... create or relogin.
		if (userService.checkUserIfExists(loginVo.getAccount())) {
			User loginUser = userService.login(loginVo.getAccount(), loginVo.getPassword());
			LOGGER.debug("www:loginUser:" + loginUser);

			if (loginUser != null) {
				// login success
				setSessionLoginUser(loginUser.getId(), loginUser.getShowName());
				if (StringUtils.isNotBlank(rememberMe) && rememberMe.equals("remember-me")) {
					setCookieLogin(loginUser.getId(), loginUser.getShowName());
				}
				return "redirect:" + (StringUtils.isNotBlank(loginVo.getToUrl()) ? loginVo.getToUrl() : "/");
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
				LOGGER.debug(":www: create a new user");
				model.put("message", "注册新用户？请再次输入密码");
				model.put("loginVo", loginVo);
				return "login_register";
			} else {
				if (!loginVo.getConfirmPassword().equals(loginVo.getPassword())) {
					result.rejectValue("error", "error.confirmPassword.invalid");
					model.put("loginVo", loginVo);
					return "login_register";
				} else {
					LOGGER.debug(":www: save a new user");
					userService.addUser(loginVo.getAccount(), loginVo.getPassword());
					model.put("message", "注册账号成功，已经赠送100猿币，请到个人账户中查看");
					model.put("loginVo", loginVo);
					return "login_register_success";
				}
			}
		}

	}

	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logout() {

		setSessionOut();
		clearCookieLogin();
		return "redirect:/";
	}
}
