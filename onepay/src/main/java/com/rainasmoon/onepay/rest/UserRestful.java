package com.rainasmoon.onepay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.util.CommonConstants;
import com.rainasmoon.onepay.util.CommonValidators;
import com.rainasmoon.onepay.web.BaseController;

@RestController
@RequestMapping(produces = "text/plain;charset=UTF-8")
public class UserRestful extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping("/restful/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "hello, my pc world...";
	}

	@RequestMapping("/restful/saveUserInfo")
	public String saveUserInfo(@RequestParam(value = "field") String field, @RequestParam(value = "value") String value) {
		if (getLoginUserId() == null) {
			return CommonConstants.NO_LOGIN_MSG;
		}
		User loginUser = userService.findUser(getLoginUserId());
		if (field.equalsIgnoreCase("email")) {
			if (!CommonValidators.isEmail(value)) {
				return "邮箱格式不正确:)";
			}
			if (userService.checkUserIfExists(value)) {
				return "邮箱已经存在:)";
			}
			loginUser.setEmail(value);
		} else if (field.equalsIgnoreCase("phone")) {
			if (!CommonValidators.isMobile(value)) {
				return "手机格式不正确:)";
			}
			if (userService.checkUserIfExists(value)) {
				return "手机号已经存在:)";
			}
			loginUser.setPhone(value);
		} else if (field.equalsIgnoreCase("nickName")) {
			loginUser.setNickName(value);
		} else {
			LOGGER.warn("illegal call of restful...");
		}
		userService.updateUser(loginUser);
		return value;
	}

}
