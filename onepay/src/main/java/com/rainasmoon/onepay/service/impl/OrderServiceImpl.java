package com.rainasmoon.onepay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.enums.OrderStatus;
import com.rainasmoon.onepay.model.Order;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.repository.springdatajpa.OrderRepository;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	protected OrderRepository repository;

	@Autowired
	private ProductRepository producRepository;

	@Override
	public Order createOrder(Long userId, Long productId, Integer money) {
		Order order = new Order();
		Product product = producRepository.findOne(productId);
		order.setBuyerId(userId);
		order.setSalerId(product.getOwnerId());
		order.setProductId(productId);
		order.setPrice(money);
		order.setStatus(OrderStatus.WAITPAY.getCode());

		repository.save(order);
		return order;
	}

	@Override
	public List<Order> findMyOrders(Long userId) {
		return repository.findBySalerIdOrBuyerId(userId);
	}

}
