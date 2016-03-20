package com.rainasmoon.onepay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.enums.YunStatus;
import com.rainasmoon.onepay.model.YunOrder;
import com.rainasmoon.onepay.repository.springdatajpa.YunOrderRepository;
import com.rainasmoon.onepay.service.YunOrderService;

@Service
public class YunOrderServiceImpl implements YunOrderService {

	@Autowired
	private YunOrderRepository repository;

	@Override
	public YunOrder addYunOrder(YunOrder yunOrder) {
		return repository.save(yunOrder);
	}

	@Override
	public List<YunOrder> findAll() {
		List<YunOrder> result = new ArrayList<YunOrder>();
		Iterable<YunOrder> all = repository.findAll();
		for (YunOrder yunOrder : all) {
			result.add(yunOrder);
		}
		return result;
	}

	@Override
	public String buyYunOrder(Long yunOrderId) {
		YunOrder yunOrder = repository.findOne(yunOrderId);
		yunOrder.setStatus(YunStatus.TRADED.getCode());
		repository.save(yunOrder);
		return null;
	}

	@Override
	public String freezeYunOrder(Long yunOrderId) {
		// TODO Auto-generated method stub
		YunOrder yunOrder = repository.findOne(yunOrderId);
		yunOrder.setStatus(YunStatus.VERIFYED.getCode());
		repository.save(yunOrder);
		return null;
	}

	@Override
	public String sellYunOrder(Long yunOrderId) {
		YunOrder yunOrder = repository.findOne(yunOrderId);
		yunOrder.setStatus(YunStatus.TRADED.getCode());
		repository.save(yunOrder);
		return null;
	}

	@Override
	public YunOrder findYunOrder(Long yunOrderId) {
		return repository.findOne(yunOrderId);
	}

}
