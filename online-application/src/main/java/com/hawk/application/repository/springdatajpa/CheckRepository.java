package com.hawk.application.repository.springdatajpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hawk.application.model.*;

public interface CheckRepository extends
		CrudRepository<Check, Integer> {

	List<Check> findAll() throws DataAccessException;
}
