package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.Feedback;
import com.rainasmoon.onepay.model.Order;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.model.ResetPasswordApplication;
import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.service.FeedbackService;
import com.rainasmoon.onepay.service.OrderService;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.service.ResetPasswordService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.vo.OrderVo;
import com.rainasmoon.onepay.vo.ProductVo;

@Controller
public class ManagerController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ResetPasswordService resetPasswordService;

	@Autowired
	private FeedbackService feedbackService;

	@Autowired
	private Mapper dozerBeanMapper;

	@RequestMapping(value = { "/manage_all_users.html" }, method = RequestMethod.GET)
	public String manageAllUsers(Map<String, Object> model) {

		List<User> results = userService.listAllUsers();

		// 完全按成交额排名的会员。
		model.put("results", results);

		return "manage_all_users";
	}

	@RequestMapping(value = { "/manage_all_sales.html" }, method = RequestMethod.GET)
	public String manageAllProducts(Map<String, Object> model) {
		if (!isLogin()) {
			return relogin();
		}
		List<Product> allsales = productService.listAllProducts();
		List<ProductVo> result = new ArrayList<>();
		for (Product product : allsales) {
			ProductVo productVo = dozerBeanMapper.map(product, ProductVo.class);
			productVo.setCurrentBiderName(userService.findUser(productVo.getCurrentBiderId()).getShowName());

			result.add(productVo);
		}
		model.put("products", result);

		return "manage_all_sales";
	}

	@RequestMapping(value = { "/manage_all_orders.html" }, method = RequestMethod.GET)
	public String manageAllOrders(Map<String, Object> model) {
		if (!isLogin()) {
			return "redirect:login.html";
		}
		List<Order> myOrders = orderService.listAllOrders();
		List<OrderVo> result = new ArrayList<>();
		for (Order order : myOrders) {
			OrderVo orderVo = dozerBeanMapper.map(order, OrderVo.class);
			orderVo.setBuyerName(userService.findUser(orderVo.getBuyerId()).getShowName());
			orderVo.setSalerName(userService.findUser(orderVo.getSalerId()).getShowName());
			orderVo.setProductName(productService.findProduct(orderVo.getProductId()).getName());
			result.add(orderVo);
		}

		model.put("orders", result);

		return "manage_all_orders";
	}

	@RequestMapping(value = { "/manage_all_applications.html" }, method = RequestMethod.GET)
	public String manageAllApplications(Map<String, Object> model) {

		List<ResetPasswordApplication> results = resetPasswordService.listAllApplications();

		model.put("results", results);

		return "manage_all_applications";
	}

	@RequestMapping(value = { "/manage_all_feedbacks.html" }, method = RequestMethod.GET)
	public String manageAllFeedbacks(Map<String, Object> model) {

		List<Feedback> results = feedbackService.listAllFeedbacks();

		model.put("results", results);

		return "manage_all_feedbacks";
	}
}
