package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByOwnerId(Long ownerId);

	List<Product> findByStatus(Integer status);

	List<Product> findByStatusOrderByIdDesc(Integer status);

	@Query("select d from Product d where d.saleModel = ?1 and d.status = ?2 and d.endDate < ?3")
	List<Product> findEndDateAndStatusProduct(Integer saleModel,
			Integer status, Date date);

	List<Product> findBySaleModelAndStatus(Integer saleModel, Integer status);
}
