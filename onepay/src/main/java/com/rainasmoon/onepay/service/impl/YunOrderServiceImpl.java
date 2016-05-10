package com.rainasmoon.onepay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainasmoon.onepay.enums.YunStatus;
import com.rainasmoon.onepay.model.YunOrder;
import com.rainasmoon.onepay.repository.springdatajpa.YunOrderRepository;
import com.rainasmoon.onepay.service.AccountService;
import com.rainasmoon.onepay.service.YunOrderService;
import com.rainasmoon.onepay.service.dto.TransferResult;

@Service
public class YunOrderServiceImpl implements YunOrderService {

	@Autowired
	private YunOrderRepository repository;

	@Autowired
	AccountService accountService;

	@Override
	@Transactional
	public String addYunOrder(YunOrder yunOrder) {
		if (yunOrder.isSell()) {
			TransferResult result = accountService.minusAccount(
					yunOrder.getUserId(), yunOrder.getAmount());
			if (result.isFail()) {
				return result.getMessage();
			}
		}
		repository.save(yunOrder);
		return "保存成功";
	}

	@Override
	@Transactional(readOnly = true)
	public List<YunOrder> findAll() {
		List<YunOrder> result = new ArrayList<YunOrder>();
		Iterable<YunOrder> all = repository.findAll();
		for (YunOrder yunOrder : all) {
			result.add(yunOrder);
		}
		return result;
	}

	@Override
	@Transactional
	public String executeYunOrder(Long userId, Long yunOrderId) {
		YunOrder yunOrder = repository.findOne(yunOrderId);

		TransferResult result = transferYunOrder(yunOrder, userId);

		if (result.isSuccess()) {
			updateYunOrderToDone(yunOrder, userId);
		}

		return result.getMessage();
	}

	private TransferResult transferYunOrder(YunOrder yunOrder, Long userId) {
		if (yunOrder.isBuy()) {
			// 对方要买猿币
			TransferResult result = accountService.transferToFreezeAccount(
					userId, yunOrder.getUserId(), yunOrder.getAmount());
			if (result.isFail()) {
				return result;
			}
		} else {
			// 对方要卖猿币: 因为在下单时，猿币已经减，所以这里只有增加操作。
			TransferResult result = accountService.addFreezeAccount(userId,
					yunOrder.getAmount());
			if (result.isFail()) {
				return result;
			}
		}
		return TransferResult.success("交易成功");
	}

	private void updateYunOrderToDone(YunOrder yunOrder, Long userId) {
		yunOrder.setDealerId(userId);
		yunOrder.setStatus(YunStatus.TRADED.getCode());
		repository.save(yunOrder);

	}

	@Override
	@Transactional
	public String unfreezeYunOrder(Long userId, Long yunOrderId) {
		YunOrder yunOrder = repository.findOne(yunOrderId);
		if (!yunOrder.canUnfreeze()) {
			return "解冻失败";
		}
		TransferResult result = accountService.unfreeze(userId,
				yunOrder.getAmount());
		if (result.isFail()) {
			return result.getMessage();
		}

		yunOrder.setStatus(YunStatus.VERIFYED.getCode());
		repository.save(yunOrder);
		return "解冻成功";
	}

	@Override
	@Transactional(readOnly = true)
	public YunOrder findYunOrder(Long yunOrderId) {
		return repository.findOne(yunOrderId);
	}

}
