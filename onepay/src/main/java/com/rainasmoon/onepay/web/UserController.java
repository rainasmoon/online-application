package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.vo.AdVo;

@Controller
public class UserController extends BaseController {

	@RequestMapping(value = { "/login.html" }, method = RequestMethod.GET)
	public String login(Map<String, Object> model) {

		return "login";
	}

	@RequestMapping(value = { "/top10users.html" }, method = RequestMethod.GET)
	public String listTop10Users(Map<String, Object> model) {

		List<User> results = new ArrayList<User>();

		for (int i = 0; i < 10; i++) {
			User t = new User();
			t.setNickName("Glen" + i);
			t.setBuyAmount(100);
			t.setSellAmount(1000);
			t.setTotalAmount(10000);

			results.add(t);
		}

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
}
