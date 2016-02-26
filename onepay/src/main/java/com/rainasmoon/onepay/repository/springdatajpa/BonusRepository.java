package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.Bonus;

public interface BonusRepository extends CrudRepository<Bonus, Integer> {

	List<Bonus> findByCreatedBy(Integer createdBy) throws DataAccessException;
}
