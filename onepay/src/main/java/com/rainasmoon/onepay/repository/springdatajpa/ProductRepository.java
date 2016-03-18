package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByOwnerId(Long ownerId);

	List<Product> findByStatus(Integer status);
}
