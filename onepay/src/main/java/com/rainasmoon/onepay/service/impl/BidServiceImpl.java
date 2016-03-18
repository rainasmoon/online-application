package com.rainasmoon.onepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.model.BidLog;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.repository.springdatajpa.BidLogRepository;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.service.BidService;

@Service
public class BidServiceImpl implements BidService {

	@Autowired
	private BidLogRepository repository;

	@Autowired
	private ProductRepository productRepository;

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
	public boolean guessMoney(Long userId, Long productId, Integer money) {
		Product product = productRepository.findOne(productId);

		boolean result = false;
		if (money >= product.getOriginalPrice()) {
			product.setPrice(money);
			product.setCurrentBiderId(userId);
			result = true;
		}

		BidLog bidLog = new BidLog();
		bidLog.setUserId(userId);
		bidLog.setProductId(productId);
		bidLog.setPrice(product.getPrice());
		repository.save(bidLog);

		return result;
	}

}
