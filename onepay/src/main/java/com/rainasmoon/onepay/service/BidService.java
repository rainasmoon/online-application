package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.model.Product;

public interface BidService {

	Product bidAddMoney(Long userId, Long productId, Integer addMoney);

	boolean guessMoney(Long userId, Long productId, Integer money);
}
