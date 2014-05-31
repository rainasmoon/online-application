package com.hawk.application.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import com.hawk.application.model.Application;

public interface ApplicationRepository extends Repository<Application, Integer> {

	void save(Application application) throws DataAccessException;

	Collection<Application> findAll() throws DataAccessException;
}
