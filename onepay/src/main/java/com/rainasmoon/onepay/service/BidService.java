package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.model.Product;

public interface BidService {

	Product bidAddMoney(Long userId, Long productId, Integer addMoney);

	String guessMoney(Long userId, Long productId, Integer money);

	String generateBidThreeDays();

	String generateBidThreeTimes();

}
