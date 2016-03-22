package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.service.dto.TransferResult;

public interface AccountService {

	TransferResult transferAccount(Long fromUserId, Long toUserId, Integer amount);

	TransferResult transferToFreezeAccount(Long fromUserId, Long toUserId, Integer amount);

	TransferResult unfreeze(Long userId, Integer amount);

	TransferResult minusAccount(Long userId, Integer amount);

	TransferResult addAccount(Long dealerId, Integer amount);
}
