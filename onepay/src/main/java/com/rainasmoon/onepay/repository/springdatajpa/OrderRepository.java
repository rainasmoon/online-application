
package com.rainasmoon.onepay.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
