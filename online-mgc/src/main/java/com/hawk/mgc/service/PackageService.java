package com.hawk.mgc.service;

import java.util.List;

import com.hawk.mgc.model.MgcPackage;
import com.hawk.mgc.model.SearchMgcPackageVo;

public interface PackageService {

	void savePackage(MgcPackage apackage);

	List<MgcPackage> findAllPackages();

	MgcPackage findPackageById(int packageId);

	void deletePackageById(int packageId);

	List<MgcPackage> searchPackages(SearchMgcPackageVo searchMgcPackageVo);

}
