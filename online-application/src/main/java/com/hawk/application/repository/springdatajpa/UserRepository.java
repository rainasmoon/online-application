package com.hawk.application.repository.springdatajpa;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hawk.application.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Collection<User> findAll() throws DataAccessException;

	User findByEmail(String email);

	@Modifying
	@Query("UPDATE User u SET u.password = :newPassword WHERE u.id = :id")
	void updatePassword(@Param("id") Integer id,
			@Param("newPassword") String newPassword);
}
