package com.rainasmoon.onepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.enums.AccountLogTypes;
import com.rainasmoon.onepay.model.AccountLog;
import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.repository.springdatajpa.AccountLogRepository;
import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.service.AccountService;
import com.rainasmoon.onepay.service.dto.TransferResult;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountLogRepository accountLogRepository;

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

		String description = String.format("transfer from [%s] to [%s] amount is [%s]", fromUser.getShowName(), toUser.getShowName(), amount);

		recordAccountLog(fromUser, -amount, AccountLogTypes.TRANSFER_TO_USER, description);
		recordAccountLog(toUser, amount, AccountLogTypes.TRANSFER_TO_USER, description);

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
		String description = String.format("market transfer from [%s] to [%s] amount is [%s]", fromUser.getShowName(), toUser.getShowName(), amount);

		recordAccountLog(fromUser, -amount, AccountLogTypes.TRASNSFER_TO_MARKET, description);

		return TransferResult.success("支付成功");
	}

	@Override
	public TransferResult unfreeze(Long userId, Integer amount) {
		User user = userRepository.findOne(userId);
		if (user.getFreezeAccount() < amount) {
			return TransferResult.fail("冻结帐户不足");
		}

		user.unfreeze(amount);

		userRepository.save(user);

		String description = String.format(" unfreeze for [%s] amount is [%s]", user.getShowName(), amount);

		recordAccountLog(user, amount, AccountLogTypes.RECEIVE_FROM_MARKET, description);

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

		String description = String.format(" minus for [%s] amount is [%s]", user.getShowName(), amount);

		recordAccountLog(user, amount, AccountLogTypes.TRASNSFER_TO_MARKET, description);

		return TransferResult.success("支付成功");
	}

	@Override
	public TransferResult addFreezeAccount(Long dealerId, Integer amount) {
		User user = userRepository.findOne(dealerId);

		user.addFreezeAccount(amount);

		userRepository.save(user);

		return TransferResult.success("支付成功");
	}

	private void recordAccountLog(User user, Integer amount, AccountLogTypes type, String description) {
		AccountLog accountLog = new AccountLog();
		accountLog.setUserId(user.getId());
		accountLog.setChangeAmount(amount);
		accountLog.setBalance(user.getAccount());
		accountLog.setType(type.getCode());
		accountLog.setDescription(description);
		accountLogRepository.save(accountLog);
	}

}
