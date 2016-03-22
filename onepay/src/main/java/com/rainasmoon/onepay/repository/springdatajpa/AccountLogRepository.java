package com.rainasmoon.onepay.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.AccountLog;

public interface AccountLogRepository extends CrudRepository<AccountLog, Long> {
}
