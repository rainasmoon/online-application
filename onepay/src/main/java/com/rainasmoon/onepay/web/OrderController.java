package com.rainasmoon.onepay.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.service.OrderService;

@Controller
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = { "/myorders.html" }, method = RequestMethod.GET)
	public String login(Map<String, Object> model) {

		model.put("orders", orderService.findMyOrders(getLoginUserId()));

		return "myorders";
	}
}
