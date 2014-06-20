package com.hawk.mgc.service;

import java.util.List;

import com.hawk.mgc.model.MgcPackage;

public interface PackageService {

	void savePackage(MgcPackage apackage);

	List<MgcPackage> findAllPackages();

}
