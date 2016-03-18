
package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rainasmoon.onepay.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	@Query("select d from Order d where d.salerId = :userId or d.buyerId = :userId")
	List<Order> findBySalerIdOrBuyerId(@Param("userId") Long userId);
}
