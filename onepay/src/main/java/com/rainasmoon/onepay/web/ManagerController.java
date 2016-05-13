package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.vo.AdVo;
import com.rainasmoon.onepay.vo.ProductVo;

@Controller
public class ManagerController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private Mapper dozerBeanMapper;

	@RequestMapping(value = { "/manage_all_users.html" }, method = RequestMethod.GET)
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

	@RequestMapping(value = { "/manage_all_sales.html" }, method = RequestMethod.GET)
	public String listMySales(Map<String, Object> model) {
		if (!isLogin()) {
			return "redirect:login.html";
		}
		List<Product> mysales = productService.listMySalesProductsPage(getLoginUserId());
		List<ProductVo> result = new ArrayList<ProductVo>();
		for (Product product : mysales) {
			ProductVo productVo = dozerBeanMapper.map(product, ProductVo.class);
			productVo.setCurrentBiderName(userService.findUser(productVo.getCurrentBiderId()).getShowName());

			result.add(productVo);
		}
		model.put("products", result);

		return "mysales";
	}
}
