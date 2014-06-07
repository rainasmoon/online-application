package com.hawk.application.repository.springdatajpa;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hawk.application.model.*;

public interface SdkRepository extends
		CrudRepository<Sdk, Integer> {

	List<Sdk> findAll() throws DataAccessException;
}
