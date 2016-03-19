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

	@Override
	public String orderPay(Long orderId) {
		Order order = repository.findOne(orderId);
		order.setStatus(OrderStatus.PAYED.getCode());
		repository.save(order);
		// TODO glen transfer the account.

		return "支付成功";
	}

	@Override
	public Order findOrder(Long orderId) {
		return repository.findOne(orderId);
	}

	@Override
	public String orderFill(Long orderId) {
		// TODO Auto-generated method stub
		Order order = repository.findOne(orderId);
		order.setStatus(OrderStatus.DOWN.getCode());
		repository.save(order);
		return null;
	}

	@Override
	public String orderReceiveStar(Long orderId) {
		// TODO Auto-generated method stub
		Order order = repository.findOne(orderId);
		order.setStatus(OrderStatus.WAITSALERSTARS.getCode());
		repository.save(order);
		return null;
	}

	@Override
	public String orderSaleStar(Long orderId) {
		// TODO Auto-generated method stub
		Order order = repository.findOne(orderId);
		order.setStatus(OrderStatus.DONE.getCode());
		repository.save(order);
		return null;
	}

	@Override
	public String orderReceive(Long orderId) {
		// TODO Auto-generated method stub
		Order order = repository.findOne(orderId);
		order.setStatus(OrderStatus.RECEIVED.getCode());
		repository.save(order);
		return null;
	}

	@Override
	public String orderSend(Long orderId) {
		// TODO Auto-generated method stub
		Order order = repository.findOne(orderId);
		order.setStatus(OrderStatus.SENDED.getCode());
		repository.save(order);
		return null;
	}

}
