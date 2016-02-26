package com.hawk.application.repository.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.hawk.application.model.Dictionary;

public interface DictionaryRepository extends Repository<Dictionary, Integer> {

	@Query("select d from Dictionary d where d.dataType='province'")
	List<Dictionary> findProvinces();
	
	@Query("select d from Dictionary d where d.dataType='city' and d.dictionaryKey=:provinceId")
	List<Dictionary> findCitys(@Param("provinceId") Integer provinceId);

	@Query("select d from Dictionary d where d.dataType='city'")
	List<Dictionary> findAllCitys();
}
