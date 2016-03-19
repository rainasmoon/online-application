package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Order;

public interface OrderService {

	public Order createOrder(Long userId, Long productId, Integer money);

	public List<Order> findMyOrders(Long userId);

	public String orderPay(Long orderId);

	public Order findOrder(Long orderId);

	public String orderFill(Long orderId);

	public String orderReceiveStar(Long orderId);

	public String orderSaleStar(Long orderId);

	public String orderReceive(Long orderId);

	public String orderSend(Long orderId);
}
