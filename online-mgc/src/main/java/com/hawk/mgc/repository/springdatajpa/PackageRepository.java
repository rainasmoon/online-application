package com.hawk.mgc.repository.springdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hawk.mgc.model.MgcPackage;

public interface PackageRepository extends CrudRepository<MgcPackage, Integer> {

	List<MgcPackage> findAll();

}
