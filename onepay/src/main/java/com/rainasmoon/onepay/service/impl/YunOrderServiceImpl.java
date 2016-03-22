package com.rainasmoon.onepay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.enums.YunStatus;
import com.rainasmoon.onepay.model.YunOrder;
import com.rainasmoon.onepay.repository.springdatajpa.YunOrderRepository;
import com.rainasmoon.onepay.service.AccountService;
import com.rainasmoon.onepay.service.YunOrderService;
import com.rainasmoon.onepay.service.dto.TransferResult;
import com.rainasmoon.onepay.util.CommonUtils;

@Service
public class YunOrderServiceImpl implements YunOrderService {

	@Autowired
	private YunOrderRepository repository;

	@Autowired
	AccountService accountService;

	@Override
	public String addYunOrder(YunOrder yunOrder) {
		if (yunOrder.isSell()) {
			TransferResult result = accountService.minusAccount(yunOrder.getUserId(), yunOrder.getAmount());
			if (result.isFail()) {
				return result.getMessage();
			}
		}
		repository.save(yunOrder);
		return "保存成功";
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
	public String executeYunOrder(Long userId, Long yunOrderId) {
		YunOrder yunOrder = repository.findOne(yunOrderId);
		if (yunOrder.isBuy()) {
			// 对方要买猿币
			TransferResult result = accountService.transferToFreezeAccount(yunOrder.getDealerId(), yunOrder.getUserId(), yunOrder.getAmount());
			if (result.isFail()) {
				return result.getMessage();
			}
		} else {
			// 对方要卖猿币: 因为在下单时，猿币已经减，所以这里只有增加操作。
			TransferResult result = accountService.addFreezeAccount(yunOrder.getDealerId(), yunOrder.getAmount());
			if (result.isFail()) {
				return result.getMessage();
			}
		}
		yunOrder.setDealerId(userId);
		yunOrder.setStatus(YunStatus.TRADED.getCode());
		repository.save(yunOrder);
		return "交易成功";
	}

	@Override
	public String unfreezeYunOrder(Long userId, Long yunOrderId, String freezeCode) {
		TransferResult result = accountService.unfreeze(userId, CommonUtils.parseFreezeCoe(freezeCode));
		if (result.isFail()) {
			return result.getMessage();
		}
		YunOrder yunOrder = repository.findOne(yunOrderId);
		yunOrder.setStatus(YunStatus.VERIFYED.getCode());
		repository.save(yunOrder);
		return "解冻成功";
	}

	@Override
	public YunOrder findYunOrder(Long yunOrderId) {
		return repository.findOne(yunOrderId);
	}

}
