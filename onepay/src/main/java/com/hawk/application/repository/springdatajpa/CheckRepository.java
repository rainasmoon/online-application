package com.hawk.application.repository.springdatajpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hawk.application.model.Check;

public interface CheckRepository extends CrudRepository<Check, Integer> {

	List<Check> findByCreatedBy(Integer createdBy) throws DataAccessException;
}
