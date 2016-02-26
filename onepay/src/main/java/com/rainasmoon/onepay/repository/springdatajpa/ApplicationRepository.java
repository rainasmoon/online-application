package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.Application;

public interface ApplicationRepository extends
		CrudRepository<Application, Integer> {

	List<Application> findByCreatedBy(Integer createdBy)
			throws DataAccessException;
}
