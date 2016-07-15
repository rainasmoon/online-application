package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.vo.AdVo;
import com.rainasmoon.onepay.vo.WelcomeVo;

@Controller
public class WelcomController extends BaseController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/welcome", "/welcome.html" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		WelcomeVo vo = new WelcomeVo();

		List<AdVo> ads = new ArrayList<>();

		AdVo ad1 = new AdVo();
		ad1.setAdTitle("注册就送100猿.");
		ad1.setAdDescription("没啥特别的，新人要有礼");
		ad1.setPicPath("pic/samplepic");
		ad1.setUrlName("马上注册");
		ad1.setUrlLink("login.html");
		ads.add(ad1);

		AdVo ad2 = new AdVo();
		ad2.setAdTitle("上传闲置也有礼.");
		ad2.setAdDescription("随手上传闲置，真的很方便");
		ad2.setPicPath("pic/samplepic");
		ad2.setUrlName("添加新物品");
		ad2.setUrlLink("addproduct.html");
		ads.add(ad2);

		AdVo ad3 = new AdVo();
		ad3.setAdTitle("猿币市场可以自由兑换喽.");
		ad3.setAdDescription("这里可以换钱，也可以买猿币");
		ad3.setPicPath("pic/samplepic");
		ad3.setUrlName("去猿币市场");
		ad3.setUrlLink("market.html");
		ads.add(ad3);

		vo.setAds(ads);

		List<AdVo> top3 = new ArrayList<>();

		List<User> users = userService.listVipUsers();

		for (User user : users) {
			AdVo uservo = new AdVo();
			uservo.setAdTitle(user.getShowName());
			uservo.setAdDescription("" + user.getCredit());
			uservo.setPicPath("pic/samplepic");
			top3.add(uservo);
		}

		vo.setTop3(top3);

		vo.setImp3(productService.listVipProducts());

		model.put("vo", vo);

		return "index";
	}
}
