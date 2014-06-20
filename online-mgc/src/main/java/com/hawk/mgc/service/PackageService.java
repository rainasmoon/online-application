package com.hawk.mgc.service;

import java.util.List;

import com.hawk.mgc.model.MgcPackage;
import com.hawk.mgc.model.MgcPackageDetail;
import com.hawk.mgc.model.SearchMgcPackageVo;

public interface PackageService {

	void savePackage(MgcPackage apackage);

	void savePackageDetail(int mgcPackageId, MgcPackageDetail mgcPackageDetail);

	void savePackageDetail(MgcPackageDetail mgcPackageDetail);

	List<MgcPackage> findAllPackages();

	MgcPackage findPackageById(int packageId);

	MgcPackageDetail findPackageDetailById(int detailId);

	void deletePackageById(int packageId);

	void deletePackageDetailById(int packageDetailId);

	List<MgcPackageDetail> searchPackageDetails(
			SearchMgcPackageVo searchMgcPackageVo);

	List<MgcPackageDetail> findPackageDetails(int packageId);

	List<MgcPackageDetail> findAllPackageDetails();

}
