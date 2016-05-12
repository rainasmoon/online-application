package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.Tag;
import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.service.TagService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.vo.AdVo;
import com.rainasmoon.onepay.vo.ResetPasswordVo;
import com.rainasmoon.onepay.vo.UserVo;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private TagService tagService;

	@Autowired
	private Mapper dozerBeanMapper;

	@RequestMapping(value = { "/top10users.html" }, method = RequestMethod.GET)
	public String listTop10Users(Map<String, Object> model) {

		List<User> results = userService.listActiveTop5Users();

		List<AdVo> vip4users = new ArrayList<AdVo>();

		AdVo ad1 = new AdVo();
		AdVo ad2 = new AdVo();
		AdVo ad3 = new AdVo();
		AdVo ad4 = new AdVo();

		ad1.setPicPath("pic/7.jpg");

		vip4users.add(ad1);
		vip4users.add(ad2);
		vip4users.add(ad3);
		vip4users.add(ad4);

		// 按活越度的会员，或4名新会员
		model.put("vip4users", vip4users);
		// 完全按成交额排名的会员。
		model.put("top10users", results);

		return "top10users";
	}

	@RequestMapping(value = { "/viewme.html" }, method = RequestMethod.GET)
	public String viewMe(Map<String, Object> model) {

		if (!isLogin()) {
			return "redirect:login.html";
		}

		User loginUser = userService.findUser(getLoginUserId());
		UserVo userVo = dozerBeanMapper.map(loginUser, UserVo.class);

		List<Tag> tags = tagService.findUserTags(getLoginUserId());
		model.put("user", userVo);
		model.put("userTags", tags);
		return "view_me";
	}

	@RequestMapping(value = { "/reset_password.html" }, method = RequestMethod.GET)
	public String resetPasswordPage() {
		return "reset_password";
	}

	@RequestMapping(value = { "/reset_password_reset.html" }, method = RequestMethod.GET)
	public String showResetPasswordResetPage(Map<String, Object> model) {
		model.put("resetPasswordVo", new ResetPasswordVo());
		return "reset_password_reset";
	}

	@RequestMapping(value = { "/reset_password_reset.html" }, method = RequestMethod.POST)
	public String resetPasswordReset(ResetPasswordVo resetPasswordVo, Map<String, Object> model) {
		return "reset_password_success";
	}
}
