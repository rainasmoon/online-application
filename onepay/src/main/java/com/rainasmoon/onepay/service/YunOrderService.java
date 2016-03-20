package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.YunOrder;

public interface YunOrderService {
	YunOrder addYunOrder(YunOrder yunOrder);

	List<YunOrder> findAll();

	String buyYunOrder(Long yunOrderId);

	String freezeYunOrder(Long yunOrderId);

	String sellYunOrder(Long yunOrderId);

	YunOrder findYunOrder(Long yunOrderId);
}
