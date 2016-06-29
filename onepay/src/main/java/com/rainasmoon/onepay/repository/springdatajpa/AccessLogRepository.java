package com.rainasmoon.onepay.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.AccessLog;

public interface AccessLogRepository extends CrudRepository<AccessLog, Long> {

}
