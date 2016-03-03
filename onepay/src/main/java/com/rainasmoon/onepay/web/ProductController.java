package com.rainasmoon.onepay.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController extends BaseController {

	@RequestMapping(value = { "/listproducts.html" }, method = RequestMethod.GET)
	public String listProducts(Map<String, Object> model) {

		return "listproducts";
	}

	@RequestMapping(value = { "/myfavorites.html" }, method = RequestMethod.GET)
	public String listMyFavorites(Map<String, Object> model) {

		return "myfavorites";
	}

	@RequestMapping(value = { "/mysales.html" }, method = RequestMethod.GET)
	public String listMySales(Map<String, Object> model) {

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
