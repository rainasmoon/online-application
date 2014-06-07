package com.hawk.application.repository.springdatajpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hawk.application.model.Application;

public interface ApplicationRepository extends
		CrudRepository<Application, Integer> {

	List<Application> findAll() throws DataAccessException;
}
