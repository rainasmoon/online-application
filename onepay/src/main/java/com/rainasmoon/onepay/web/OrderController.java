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
import com.rainasmoon.onepay.vo.FillOrderVo;
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
			orderVo.setBuyerName(userService.findUser(orderVo.getBuyerId()).getShowName());
			orderVo.setSalerName(userService.findUser(orderVo.getSalerId()).getShowName());
			orderVo.setProductName(productService.findProduct(orderVo.getProductId()).getName());
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
	public String showOrderFillForm(Long orderId, Map<String, Object> model) {
		model.put("fillOrderVo", new FillOrderVo());
		model.put("orderId", orderId);
		return "order_fill";
	}

	@RequestMapping(value = { "/order_fill.html" }, method = RequestMethod.POST)
	public String orderFill(Long orderId, FillOrderVo fillOrderVo, Map<String, Object> model) {

		String message = orderService.orderFill(orderId, fillOrderVo);

		model.put("message", message);
		return "order_fill_success";
	}

	@RequestMapping(value = { "/order_receive_star.html" }, method = RequestMethod.GET)
	public String showOrderReceiveStarForm(Long orderId, Map<String, Object> model) {

		model.put("orderId", orderId);
		return "order_receive_star";
	}

	@RequestMapping(value = { "/order_receive_star.html" }, method = RequestMethod.POST)
	public String orderReceiveStar(Long orderId, Integer stars, Map<String, Object> model) {
		String message = orderService.orderReceiveStar(orderId, stars);
		model.put("message", message);
		return "order_receive_star_success";
	}

	@RequestMapping(value = { "/order_sale_star.html" }, method = RequestMethod.GET)
	public String showOrderSaleStarForm(Long orderId, Map<String, Object> model) {

		model.put("orderId", orderId);
		return "order_sale_star";
	}

	@RequestMapping(value = { "/order_sale_star.html" }, method = RequestMethod.POST)
	public String orderSaleStar(Long orderId, Integer stars, Map<String, Object> model) {
		String message = orderService.orderSaleStar(orderId, stars);
		model.put("message", message);
		return "order_sale_star_success";
	}

	@RequestMapping(value = { "order_receive.html" }, method = RequestMethod.GET)
	public String showOrderReceiveForm(Long orderId, Map<String, Object> model) {

		model.put("orderId", orderId);
		return "order_receive";
	}

	@RequestMapping(value = { "order_receive.html" }, method = RequestMethod.POST)
	public String orderReceive(Long orderId, Map<String, Object> model) {
		String message = orderService.orderReceive(orderId);
		model.put("message", message);
		return "order_receive_success";
	}

	@RequestMapping(value = { "order_send.html" }, method = RequestMethod.GET)
	public String showOrderSendForm(Long orderId, Map<String, Object> model) {
		Order order = orderService.findOrder(orderId);
		OrderVo orderVo = dozerBeanMapper.map(order, OrderVo.class);
		orderVo.setBuyerName(userService.findUser(orderVo.getBuyerId()).getShowName());
		orderVo.setProductName(productService.findProduct(orderVo.getProductId()).getName());

		model.put("orderId", orderId);
		model.put("orderVo", orderVo);
		return "order_send";
	}

	@RequestMapping(value = { "order_send.html" }, method = RequestMethod.POST)
	public String orderSend(Long orderId, Map<String, Object> model) {
		String message = orderService.orderSend(orderId);
		model.put("message", message);
		return "order_send_success";
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
