package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.*;

public interface SdkRepository extends
		CrudRepository<Sdk, Integer> {

	List<Sdk> findAll() throws DataAccessException;
}
