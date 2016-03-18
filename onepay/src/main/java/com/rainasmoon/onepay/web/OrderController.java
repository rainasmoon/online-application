package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.enums.OperationEnum;
import com.rainasmoon.onepay.enums.OrderStatus;
import com.rainasmoon.onepay.model.Order;
import com.rainasmoon.onepay.service.OrderService;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.vo.OrderVo;

@Controller
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private Mapper dozerBeanMapper;

	@RequestMapping(value = { "/myorders.html" }, method = RequestMethod.GET)
	public String myOrders(Map<String, Object> model) {

		List<Order> myOrders = orderService.findMyOrders(getLoginUserId());
		List<OrderVo> result = new ArrayList<OrderVo>();
		for (Order order : myOrders) {
			OrderVo orderVo = dozerBeanMapper.map(order, OrderVo.class);
			orderVo.setBuyerName(userService.findUser(orderVo.getBuyerId())
					.getShowName());
			orderVo.setSalerName(userService.findUser(orderVo.getSalerId())
					.getShowName());
			orderVo.setProductName(productService.findProduct(
					orderVo.getProductId()).getName());
			orderVo.setOperation(transferToOperation(getLoginUserId(), orderVo));
			result.add(orderVo);
		}

		model.put("orders", result);

		return "myorders";
	}

	private OperationEnum transferToOperation(Long loginUserId, OrderVo orderVo) {
		if (loginUserId == orderVo.getBuyerId()) {
			return OrderStatus.getBuyerOperation(orderVo.getEnumStatus());
		}
		if (loginUserId == orderVo.getSalerId()) {
			return OrderStatus.getSalerOperation(orderVo.getEnumStatus());
		}
		return OperationEnum.NOTHING;
	}
}
