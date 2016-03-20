package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.YunOrder;

public interface YunOrderService {
	YunOrder addYunOrder(YunOrder yunOrder);

	List<YunOrder> findAll();

	String buyYunOrder(Long userId, Long yunOrderId);

	String freezeYunOrder(Long userId, Long yunOrderId, String freezeCode);

	String sellYunOrder(Long userId, Long yunOrderId);

	YunOrder findYunOrder(Long yunOrderId);
}
