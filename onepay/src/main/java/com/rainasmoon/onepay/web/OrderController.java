package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.Order;
import com.rainasmoon.onepay.service.OrderService;
import com.rainasmoon.onepay.vo.OrderVo;

@Controller
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private Mapper dozerBeanMapper;

	@RequestMapping(value = { "/myorders.html" }, method = RequestMethod.GET)
	public String myOrders(Map<String, Object> model) {

		List<Order> myOrders = orderService.findMyOrders(getLoginUserId());
		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		for (Order order : myOrders) {
			orderVos.add(dozerBeanMapper.map(order, OrderVo.class));
		}

		model.put("orders", orderVos);

		return "myorders";
	}
}
