package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Order;

/**
 * 添写定单地址，定单支付，发收货，评价定单
 * 
 * @comment
 * @author wlcic-glen
 * @date 2016年3月21日 下午2:30:02
 * @version 1.0.0
 * @see
 */
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
