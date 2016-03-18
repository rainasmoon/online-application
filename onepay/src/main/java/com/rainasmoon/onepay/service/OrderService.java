package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Order;

public interface OrderService {

	public Order createOrder(Long userId, Long productId, Integer money);

	public List<Order> findMyOrders(Long userId);
}
