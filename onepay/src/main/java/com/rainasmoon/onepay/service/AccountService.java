package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.service.dto.TransferResult;

public interface AccountService {

	TransferResult transferAccount(Long fromUserId, Long toUserId, Integer amount);
}
