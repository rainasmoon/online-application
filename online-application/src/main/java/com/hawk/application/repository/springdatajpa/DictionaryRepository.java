package com.hawk.application.repository.springdatajpa;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.hawk.application.model.Dictionary;
import com.hawk.application.model.User;

public interface DictionaryRepository extends Repository<Dictionary, Integer> {

	@Query("select d from Dictionary d where d.dataType='province'")
	Collection<Dictionary> findProvinces();
	
	@Query("select d from Dictionary d where d.dataType='city' and d.dictionaryKey=:provinceId")
	Collection<Dictionary> findCitys(@Param("provinceId") Integer provinceId);

	@Query("select d from Dictionary d where d.dataType='city'")
	Collection<Dictionary> findAllCitys();
}
