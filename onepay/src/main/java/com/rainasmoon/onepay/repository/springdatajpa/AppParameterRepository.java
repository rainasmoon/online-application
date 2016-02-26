package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.AppParameter;

public interface AppParameterRepository extends
		CrudRepository<AppParameter, Integer> {

	List<AppParameter> findByCreatedBy(Integer createdBy)
			throws DataAccessException;
}
