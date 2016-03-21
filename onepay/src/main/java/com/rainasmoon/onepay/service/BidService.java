package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.vo.BidRefreshVo;

public interface BidService {

	String bidAddMoney(Long userId, Long productId, Integer addMoney);

	String guessMoney(Long userId, Long productId, Integer money);

	String generateBidThreeDays();

	String generateBidThreeTimes();

	BidRefreshVo getBidRefreshVo(Long productId);

}
