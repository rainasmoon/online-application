package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.YunOrder;

public interface YunOrderService {
	YunOrder save(YunOrder yunOrder);

	List<YunOrder> findAll();
}
