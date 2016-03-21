package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.vo.BidRefreshVo;

/**
 * 竞拍，产生定单
 * 
 * @comment
 * @author wlcic-glen
 * @date 2016年3月21日 下午2:28:12
 * @version 1.0.0
 * @see
 */
public interface BidService {

	String bidAddMoney(Long userId, Long productId, Integer addMoney);

	String guessMoney(Long userId, Long productId, Integer money);

	String generateBidThreeDays();

	String generateBidThreeTimes();

	BidRefreshVo getBidRefreshVo(Long productId);

}
