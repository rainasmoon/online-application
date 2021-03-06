package com.hawk.mgc.repository.springdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hawk.mgc.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUserName(String userName);

	List<User> findAll();

}
