package com.rainasmoon.onepay.service.impl;

import java.util.Date;

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
		productRepository.save(product);

		BidLog bidLog = new BidLog();
		bidLog.setUserId(userId);
		bidLog.setProductId(productId);
		bidLog.setPrice(product.getPrice());
		bidLog.setCreateDate(new Date());
		repository.save(bidLog);

		return product;
	}

}
