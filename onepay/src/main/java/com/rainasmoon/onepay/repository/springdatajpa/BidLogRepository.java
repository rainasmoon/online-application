package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.BidLog;

public interface BidLogRepository extends CrudRepository<BidLog, Long> {

	@Query("select d from BidLog d where d.userId = ?1 and d.productId = ?2 and d.createDate >= ?3 and d.createDate < ?4")
	List<BidLog> findBidLogOnDate(Long userId, Long productId, Date beginDate,
			Date endDate);

	List<BidLog> findByProductIdOrderByCreateDateDesc(Long productId);

}
