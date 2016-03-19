package com.rainasmoon.onepay.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.YunOrder;

public interface YunOrderRepository extends CrudRepository<YunOrder, Long> {
}
