package com.hawk.mgc.repository.springdatajpa;

import java.util.List;

import com.hawk.mgc.model.MgcPackageDetail;
import com.hawk.mgc.model.SearchMgcPackageVo;

public interface PackageDetailRepositoryCustom {

	List<MgcPackageDetail> searchPackageDetails(
			SearchMgcPackageVo searchMgcPackageVo);
}
