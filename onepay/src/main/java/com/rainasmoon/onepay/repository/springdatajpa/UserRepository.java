
package com.rainasmoon.onepay.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import com.rainasmoon.onepay.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
