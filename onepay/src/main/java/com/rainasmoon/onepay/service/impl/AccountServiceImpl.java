package com.rainasmoon.onepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.service.AccountService;
import com.rainasmoon.onepay.service.dto.TransferResult;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public TransferResult transferAccount(Long fromUserId, Long toUserId, Integer amount) {
		User fromUser = userRepository.findOne(fromUserId);
		User toUser = userRepository.findOne(toUserId);
		if (fromUser.getAccount() < amount) {
			return TransferResult.fail("账户余额不足");
		}

		fromUser.minusAccount(amount);
		toUser.addAccount(amount);

		userRepository.save(fromUser);
		userRepository.save(toUser);

		return TransferResult.success("支付成功");
	}

	@Override
	public TransferResult transferToFreezeAccount(Long fromUserId, Long toUserId, Integer amount) {
		User fromUser = userRepository.findOne(fromUserId);
		User toUser = userRepository.findOne(toUserId);
		if (fromUser.getAccount() < amount) {
			return TransferResult.fail("账户余额不足");
		}

		fromUser.minusAccount(amount);
		toUser.addFreezeAccount(amount);

		userRepository.save(fromUser);
		userRepository.save(toUser);

		return TransferResult.success("支付成功");
	}

	@Override
	public TransferResult unfreeze(Long userId, Integer amount) {
		User user = userRepository.findOne(userId);
		if (user.getFreezeAccount() < amount) {
			return TransferResult.fail("冻结帐户不足");
		}

		user.unfreeze(amount);

		return TransferResult.success("解冻成功");
	}

	@Override
	public TransferResult minusAccount(Long userId, Integer amount) {
		User user = userRepository.findOne(userId);
		if (user.getAccount() < amount) {
			return TransferResult.fail("账户余额不足");
		}

		user.minusAccount(amount);

		userRepository.save(user);

		return TransferResult.success("支付成功");
	}

	@Override
	public TransferResult addAccount(Long dealerId, Integer amount) {
		User user = userRepository.findOne(dealerId);

		user.addAccount(amount);

		userRepository.save(user);

		return TransferResult.success("支付成功");
	}

}
