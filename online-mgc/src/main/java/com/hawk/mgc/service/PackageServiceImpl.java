package com.hawk.mgc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hawk.mgc.model.MgcPackage;
import com.hawk.mgc.repository.springdatajpa.PackageRepository;

@Service
public class PackageServiceImpl implements PackageService {

	private PackageRepository packageRepository;

	@Autowired
	public PackageServiceImpl(PackageRepository packageRepository) {
		this.packageRepository = packageRepository;

	}

	@Transactional
	public void savePackage(MgcPackage apcakage) throws DataAccessException {
		packageRepository.save(apcakage);

	}

	@Override
	@Transactional(readOnly = true)
	public List<MgcPackage> findAllPackages() {

		return packageRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public MgcPackage findPackageById(int packageId) {

		return packageRepository.findOne(packageId);
	}

	@Override
	@Transactional
	public void deletePackageById(int packageId) {
		packageRepository.delete(packageId);

	}

}
