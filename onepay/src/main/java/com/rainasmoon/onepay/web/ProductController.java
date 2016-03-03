package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.vo.ProductListPageVo;
import com.rainasmoon.onepay.vo.ProductVo;

@Controller
public class ProductController extends BaseController {

	@RequestMapping(value = { "/listproducts.html" }, method = RequestMethod.GET)
	public String listProducts(Map<String, Object> model) {
		ProductListPageVo vo = new ProductListPageVo();

		vo.setTotalAmount(1000000000);
		vo.setTodayAmount(1000000);

		List<User> activeTop5Users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User t = new User();
			t.setNickName("Glen" + i);
			t.setBuyAmount(100);
			t.setSellAmount(1000);
			t.setTotalAmount(10000 * i);

			activeTop5Users.add(t);
		}
		vo.setActiveTop5Users(activeTop5Users);
		List<ProductVo> products = new ArrayList<ProductVo>();
		for (int i = 0; i < 50; i++) {
			ProductVo p = new ProductVo();
			p.setAdTitle("Good" + i);
			products.add(p);
		}
		vo.setProducts(products);

		model.put("vo", vo);

		return "listproducts";
	}

	@RequestMapping(value = { "/myfavorites.html" }, method = RequestMethod.GET)
	public String listMyFavorites(Map<String, Object> model) {

		List<ProductVo> products = new ArrayList<ProductVo>();
		for (int i = 0; i < 50; i++) {
			ProductVo p = new ProductVo();
			p.setAdTitle("Good" + i);
			products.add(p);
		}

		model.put("products", products);

		return "myfavorites";
	}

	@RequestMapping(value = { "/mysales.html" }, method = RequestMethod.GET)
	public String listMySales(Map<String, Object> model) {

		List<ProductVo> products = new ArrayList<ProductVo>();
		for (int i = 0; i < 50; i++) {
			ProductVo p = new ProductVo();
			p.setAdTitle("Good" + i);
			products.add(p);
		}

		model.put("products", products);

		return "mysales";
	}

	@RequestMapping(value = { "/addproduct.html" }, method = RequestMethod.GET)
	public String addProduct(Map<String, Object> model) {

		return "addproduct";
	}

	@RequestMapping(value = { "/bid.html" }, method = RequestMethod.GET)
	public String bid(Map<String, Object> model) {

		return "bid";
	}

	@RequestMapping(value = { "/guessprice.html" }, method = RequestMethod.GET)
	public String guessPrice(Map<String, Object> model) {

		return "guessprice";
	}
}
