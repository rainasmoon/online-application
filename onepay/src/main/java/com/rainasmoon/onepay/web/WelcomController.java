package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.vo.AdVo;
import com.rainasmoon.onepay.vo.WelcomeVo;

@Controller
public class WelcomController extends BaseController {

	@RequestMapping(value = { "/", "/welcome", "/welcome.html" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		WelcomeVo vo = new WelcomeVo();

		List<AdVo> ads = new ArrayList<AdVo>();
		for (int i = 0; i < 3; i++) {
			AdVo ad = new AdVo();
			ad.setPicPath("pic/1.jpg");
			ads.add(ad);
		}
		vo.setAds(ads);

		List<AdVo> top3 = new ArrayList<AdVo>();
		for (int i = 0; i < 3; i++) {
			AdVo ad = new AdVo();
			ad.setPicPath("pic/1.jpg");
			top3.add(ad);
		}
		vo.setTop3(top3);

		List<AdVo> imp3 = new ArrayList<AdVo>();
		for (int i = 0; i < 3; i++) {
			AdVo ad = new AdVo();
			ad.setPicPath("pic/1.jpg");
			imp3.add(ad);
		}
		vo.setImp3(imp3);

		model.put("vo", vo);
		return "index";
	}
}
