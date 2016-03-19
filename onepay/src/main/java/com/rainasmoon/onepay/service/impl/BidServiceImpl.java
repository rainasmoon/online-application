package com.rainasmoon.onepay.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.enums.ProductStatus;
import com.rainasmoon.onepay.model.BidLog;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.repository.springdatajpa.BidLogRepository;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.service.BidService;
import com.rainasmoon.onepay.service.OrderService;

@Service
public class BidServiceImpl implements BidService {

	Logger LOGGER = LoggerFactory.getLogger(BidServiceImpl.class);

	@Autowired
	private BidLogRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderService orderService;

	@Override
	public Product bidAddMoney(Long userId, Long productId, Integer addMoney) {
		Product product = productRepository.findOne(productId);
		product.addPrice(addMoney);
		product.setCurrentBiderId(userId);
		productRepository.save(product);

		BidLog bidLog = new BidLog();
		bidLog.setUserId(userId);
		bidLog.setProductId(productId);
		bidLog.setPrice(product.getPrice());
		repository.save(bidLog);

		return product;
	}

	@Override
	public String guessMoney(Long userId, Long productId, Integer money) {
		Product product = productRepository.findOne(productId);

		if (!product.isOnSale()) {
			return "下架了";
		}

		if (hasOneBidLog(userId, productId, new Date())) {
			return "猜过了，明天再来试试？";
		}
		boolean result = false;
		if (money >= product.getOriginalPrice()) {
			product.setPrice(money);
			product.setCurrentBiderId(userId);
			product.setStatus(ProductStatus.DEAL.getCode());

			productRepository.save(product);
			orderService.createOrder(userId, productId, money);

			result = true;
		}

		BidLog bidLog = new BidLog();
		bidLog.setUserId(userId);
		bidLog.setProductId(productId);
		bidLog.setPrice(product.getPrice());
		repository.save(bidLog);

		return result ? "成交了" : "太低了，不卖";
	}

	private boolean hasOneBidLog(Long userId, Long productId, Date date) {
		DateFormat sf = new SimpleDateFormat("yyyyMMdd");
		DateFormat sfFull = new SimpleDateFormat("yyyyMMddhhmmss");

		List<BidLog> result = null;
		try {
			result = repository.findBidLogOnDate(userId, productId,
					sfFull.parse(sf.format(new Date()) + "000000"),
					sfFull.parse(sf.format(new Date()) + "235959"));
		} catch (ParseException e) {
			LOGGER.info("parase date exception. wired.", e);
		}
		return result == null ? false : (result.size() > 0 ? true : false);
	}

}
