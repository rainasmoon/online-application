package com.hawk.mgc.repository.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hawk.mgc.model.MgcPackageDetail;

public interface PackageDetailRepository extends
		CrudRepository<MgcPackageDetail, Integer> {

	List<MgcPackageDetail> findAll();

	@Query("SELECT m FROM MgcPackageDetail m WHERE m.mgcPackage.id = :packageId")
	List<MgcPackageDetail> findByPackageId(@Param("packageId") Integer packageId);

}
