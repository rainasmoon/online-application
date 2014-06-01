package com.hawk.application.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hawk.application.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Collection<User> findAll() throws DataAccessException;

	User findByEmail(String email);
}
