
package com.rainasmoon.onepay.repository.springdatajpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rainasmoon.onepay.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select d from User d where d.email=:loginName or d.phone=:loginName")
	User findByEmailOrPhone(@Param("loginName") String loginName);

}
