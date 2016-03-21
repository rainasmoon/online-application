package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.YunOrder;

/**
 * 猿币交换相关，无收发货
 * 
 * @comment
 * @author wlcic-glen
 * @date 2016年3月21日 下午2:31:46
 * @version 1.0.0
 * @see
 */
public interface YunOrderService {
	YunOrder addYunOrder(YunOrder yunOrder);

	List<YunOrder> findAll();

	String buyYunOrder(Long userId, Long yunOrderId);

	String freezeYunOrder(Long userId, Long yunOrderId, String freezeCode);

	String sellYunOrder(Long userId, Long yunOrderId);

	YunOrder findYunOrder(Long yunOrderId);
}
