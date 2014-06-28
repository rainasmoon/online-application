package com.hawk.mgc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hawk.mgc.model.MgcPackage;
import com.hawk.mgc.model.MgcPackageDetail;
import com.hawk.mgc.model.SearchMgcPackageVo;
import com.hawk.mgc.repository.springdatajpa.PackageDetailRepository;
import com.hawk.mgc.repository.springdatajpa.PackageRepository;

@Service
public class PackageServiceImpl implements PackageService {

	private PackageRepository packageRepository;
	private PackageDetailRepository packageDetailRepository;

	@Autowired
	public PackageServiceImpl(PackageRepository packageRepository,
			PackageDetailRepository packageDetailRepository) {
		this.packageRepository = packageRepository;
		this.packageDetailRepository = packageDetailRepository;

	}

	@Transactional
	public void savePackage(MgcPackage apacakage) throws DataAccessException {
		if (apacakage.isNew()) {
			apacakage.setCreatedDate(new Date());
			apacakage.setUpdatedDate(apacakage.getCreatedDate());
		} else {
			apacakage.setUpdatedDate(new Date());
		}
		packageRepository.save(apacakage);

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

	@Override
	@Transactional
	public void savePackageDetail(int mgcPackageId,
			MgcPackageDetail mgcPackageDetail) {
		MgcPackage mgcPackage = new MgcPackage();
		mgcPackage.setId(mgcPackageId);
		mgcPackageDetail.setMgcPackage(mgcPackage);

		savePackageDetail(mgcPackageDetail);

	}

	@Override
	@Transactional
	public void savePackageDetail(MgcPackageDetail mgcPackageDetail) {
		packageDetailRepository.save(mgcPackageDetail);

	}

	@Override
	@Transactional(readOnly = true)
	public MgcPackageDetail findPackageDetailById(int detailId) {

		return packageDetailRepository.findOne(detailId);
	}

	@Override
	@Transactional
	public void deletePackageDetailById(int packageDetailId) {
		packageDetailRepository.delete(packageDetailId);

	}

	@Override
	public List<MgcPackageDetail> searchPackageDetails(
			SearchMgcPackageVo searchMgcPackageVo) {
		if (searchMgcPackageVo.getDateTo() != null) {
			searchMgcPackageVo
					.setDateTo(convertDateToEndOfThatDay(searchMgcPackageVo
							.getDateTo()));
		}
		return packageDetailRepository.searchPackageDetails(searchMgcPackageVo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MgcPackageDetail> findPackageDetails(int packageId) {
		return packageDetailRepository.findByPackageId(packageId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MgcPackageDetail> findAllPackageDetails() {
		return packageDetailRepository.findAll();
	}

	private Date convertDateToEndOfThatDay(Date dateTo) {

		return new Date(dateTo.getTime() + 24 * 60 * 60 * 1000 - 1);
	}

}
