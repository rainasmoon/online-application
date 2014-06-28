package com.hawk.mgc.repository.springdatajpa;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.hawk.mgc.model.MgcPackage;
import com.hawk.mgc.model.MgcPackageDetail;
import com.hawk.mgc.model.SearchMgcPackageVo;

public class PackageDetailRepositoryImpl implements
		PackageDetailRepositoryCustom {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PackageDetailRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public List<MgcPackageDetail> searchPackageDetails(
			SearchMgcPackageVo searchMgcPackageVo) {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<MgcPackageDetail> criteriaQuery = cb
				.createQuery(MgcPackageDetail.class);
		Root<MgcPackageDetail> cRoot = criteriaQuery
				.from(MgcPackageDetail.class);
		criteriaQuery.select(cRoot);

		Predicate mainPredicate = null;

		mainPredicate = buildPackage(cb, mainPredicate, cRoot,
				searchMgcPackageVo.getMgcPackage());

		mainPredicate = buildProduct(cb, mainPredicate, cRoot,
				searchMgcPackageVo.getMgcProduct());

		// data from & data to
		mainPredicate = buildDateParemeters(cb, mainPredicate, cRoot,
				searchMgcPackageVo.getDateFrom(),
				searchMgcPackageVo.getDateTo());

		if (mainPredicate != null) {
			LOGGER.info(":www:" + mainPredicate);
			criteriaQuery.where(mainPredicate);

		}

		Expression<Timestamp> createdDateColumn = cRoot
				.<Timestamp> get("detailDate");
		criteriaQuery.orderBy(cb.desc(createdDateColumn));

		TypedQuery<MgcPackageDetail> query = em.createQuery(criteriaQuery);

		List<MgcPackageDetail> results = query.getResultList();

		return results;
	}

	private Predicate buildDateParemeters(CriteriaBuilder cb,
			Predicate mainPredicate, Root<MgcPackageDetail> cRoot,
			Date dateFrom, Date dateTo) {
		if (dateFrom != null && dateTo != null) {
			Predicate tempPredicate = cb.between(
					cRoot.<Timestamp> get("detailDate"),
					new Timestamp(dateFrom.getTime()),
					new Timestamp(dateTo.getTime()));
			mainPredicate = combinePredicate(cb, mainPredicate, tempPredicate);
		}
		return mainPredicate;
	}

	private Predicate buildPackage(CriteriaBuilder cb, Predicate mainPredicate,
			Root<MgcPackageDetail> cRoot, MgcPackage mgcPackage) {
		if (mgcPackage != null && mgcPackage.getId() != null) {
			Predicate tempPredicate = cb.equal(cRoot.get("mgcPackage")
					.get("id"), mgcPackage.getId());
			mainPredicate = combinePredicate(cb, mainPredicate, tempPredicate);
		}
		return mainPredicate;

	}

	private Predicate buildProduct(CriteriaBuilder cb, Predicate mainPredicate,
			Root<MgcPackageDetail> cRoot, String product) {
		if (!StringUtils.isEmpty(product)) {
			Predicate tempPredicate = cb.equal(
					cRoot.get("mgcPackage").get("productionName"), product);
			mainPredicate = combinePredicate(cb, mainPredicate, tempPredicate);
		}
		return mainPredicate;

	}

	public Predicate combinePredicate(CriteriaBuilder cb,
			Predicate mainPredicate, Predicate tempPredicate) {
		if (mainPredicate == null) {
			mainPredicate = tempPredicate;
		} else {
			mainPredicate = cb.and(mainPredicate, tempPredicate);
		}
		return mainPredicate;
	}

}
