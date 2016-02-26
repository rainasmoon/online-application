package com.hawk.application.repository.springdatajpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hawk.application.model.AppParameter;

public interface AppParameterRepository extends
		CrudRepository<AppParameter, Integer> {

	List<AppParameter> findByCreatedBy(Integer createdBy)
			throws DataAccessException;
}
