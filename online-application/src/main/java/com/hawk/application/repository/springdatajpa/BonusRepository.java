package com.hawk.application.repository.springdatajpa;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hawk.application.model.*;

public interface BonusRepository extends
		CrudRepository<Bonus, Integer> {

	List<Bonus> findAll() throws DataAccessException;
}
