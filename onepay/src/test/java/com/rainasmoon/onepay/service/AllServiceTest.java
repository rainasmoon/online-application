package com.rainasmoon.onepay.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainasmoon.onepay.enums.SaleModels;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.model.User;

public class AllServiceTest extends BaseTest {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
	OrderService orderService;

	@Autowired
	BidService bidService;

	@Test
	public void shouldTestOrderSuccess() {
		String fromUserEmail = "fromUser@Test.com";
		String toUserEmail = "toUser@Test.com";
		String password = "123456";

		User toUser = userService.addUser(toUserEmail, password);

		userService.login(fromUserEmail, password);

		Product product = new Product();
		product.setName("testProduct");
		product.setSaleModel(SaleModels.GUESSPRICE.getCode());
		productService.addProduct(product);

		userService.login(toUserEmail, password);

		bidService.guessMoney(toUser.getId(), product.getId(), 2);

	}
}
