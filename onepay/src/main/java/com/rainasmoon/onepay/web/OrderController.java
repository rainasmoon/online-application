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
import com.rainasmoon.onepay.model.User;
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

	@RequestMapping(value = { "/order_pay.html" }, method = RequestMethod.GET)
	public String showOrderPayForm(Long orderId, Map<String, Object> model) {
		User loginUser = userService.findUser(getLoginUserId());
		Order order = orderService.findOrder(orderId);
		if (loginUser.getAccount() < order.getPrice()) {
			model.put("message", "账户余额不足");
		}
		model.put("orderId", orderId);
		model.put("amount", order.getPrice());
		model.put("account", loginUser.getAccount());
		return "order_pay";
	}

	@RequestMapping(value = { "/order_pay.html" }, method = RequestMethod.POST)
	public String orderPay(Long orderId, Map<String, Object> model) {
		String message = orderService.orderPay(orderId);
		model.put("message", message);
		return "order_pay_success";
	}

	@RequestMapping(value = { "/order_fill.html" }, method = RequestMethod.GET)
	public String showOrderFillForm() {
		return "order_fill";
	}

	@RequestMapping(value = { "/order_fill.html" }, method = RequestMethod.POST)
	public String orderFill() {
		return "order_fill";
	}

	@RequestMapping(value = { "/order_receive_star.html" }, method = RequestMethod.GET)
	public String showOrderReceiveStarForm() {
		return "order_receive_star";
	}

	@RequestMapping(value = { "/order_receive_star.html" }, method = RequestMethod.POST)
	public String orderReceiveStar() {
		return "order_receive_star";
	}

	@RequestMapping(value = { "/order_sale_star.html" }, method = RequestMethod.GET)
	public String showOrderSaleStarForm() {
		return "order_sale_star";
	}

	@RequestMapping(value = { "/order_sale_star.html" }, method = RequestMethod.POST)
	public String orderSaleStar() {
		return "order_sale_star";
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
