package com.rainasmoon.onepay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainasmoon.onepay.enums.OrderStatus;
import com.rainasmoon.onepay.model.Order;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.repository.springdatajpa.OrderRepository;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.service.AccountService;
import com.rainasmoon.onepay.service.NoticeService;
import com.rainasmoon.onepay.service.OrderService;
import com.rainasmoon.onepay.service.dto.TransferResult;
import com.rainasmoon.onepay.vo.FillOrderVo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	protected OrderRepository repository;

	@Autowired
	private ProductRepository producRepository;

	@Autowired
	private AccountService accountService;

	@Autowired
	private NoticeService noticeService;

	@Override
	@Transactional
	public Order createOrder(Long userId, Long productId, Integer money) {
		Order order = new Order();
		Product product = producRepository.findOne(productId);
		order.setBuyerId(userId);
		order.setSalerId(product.getOwnerId());
		order.setProductId(productId);
		order.setPrice(money);
		order.setStatus(OrderStatus.WAITPAY.getCode());

		repository.save(order);
		noticeService.makeOrderNotice(order);
		return order;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Order> findMyOrders(Long userId) {

		return repository.findBySalerIdOrBuyerId(userId);
	}

	@Override
	@Transactional
	public String orderPay(Long orderId) {

		Order order = repository.findOne(orderId);
		TransferResult result = accountService.transferAccount(
				order.getBuyerId(), order.getSalerId(), order.getPrice());
		if (result.isSuccess()) {
			order.setStatus(OrderStatus.PAYED.getCode());
			repository.save(order);
			noticeService.makeOrderNotice(order);
		}

		return result.getMessage();
	}

	@Override
	@Transactional(readOnly = true)
	public Order findOrder(Long orderId) {
		return repository.findOne(orderId);
	}

	@Override
	@Transactional
	public String orderFill(Long orderId, FillOrderVo fillOrderVo) {
		Order order = repository.findOne(orderId);
		order.setReceiverName(fillOrderVo.getReceiverName());
		order.setReceiverPhone(fillOrderVo.getReceiverPhone());
		order.setReceiverAddress(fillOrderVo.getReceiverAddress());
		order.setReceiverPostcode(fillOrderVo.getReceiverPostcode());

		order.setSenderName(fillOrderVo.getSenderName());
		order.setSenderPhone(fillOrderVo.getSenderPhone());
		order.setSenderAddress(fillOrderVo.getSenderAddress());
		order.setSenderPostcode(fillOrderVo.getSenderPostcode());

		order.setStatus(OrderStatus.DOWN.getCode());
		repository.save(order);
		return null;
	}

	@Override
	@Transactional
	public String orderReceiveStar(Long orderId, Integer stars) {
		Order order = repository.findOne(orderId);
		order.setReceiverStars(stars);
		order.setStatus(OrderStatus.WAITSALERSTARS.getCode());
		repository.save(order);
		return "评价成功";
	}

	@Override
	@Transactional
	public String orderSaleStar(Long orderId, Integer stars) {
		Order order = repository.findOne(orderId);
		order.setSenderStars(stars);
		order.setStatus(OrderStatus.DONE.getCode());
		repository.save(order);
		return "评价成功";
	}

	@Override
	@Transactional
	public String orderReceive(Long orderId) {
		Order order = repository.findOne(orderId);
		order.setStatus(OrderStatus.RECEIVED.getCode());
		repository.save(order);
		return null;
	}

	@Override
	@Transactional
	public String orderSend(Long orderId) {
		Order order = repository.findOne(orderId);
		order.setStatus(OrderStatus.SENDED.getCode());
		repository.save(order);
		noticeService.makeOrderNotice(order);
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Order> listAllOrders() {
		return repository.findAll();
	}

}
