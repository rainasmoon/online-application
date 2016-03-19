package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.YunOrder;

public interface YunOrderService {
	YunOrder addYunOrder(YunOrder yunOrder);

	List<YunOrder> findAll();
}
