package com.hawk.application.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hawk.application.model.Application;

public interface ApplicationRepository extends
		CrudRepository<Application, Integer> {

	Collection<Application> findAll() throws DataAccessException;
}
