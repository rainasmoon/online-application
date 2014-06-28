package com.hawk.mgc.repository.springdatajpa;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hawk.mgc.model.MgcPackage;
import com.hawk.mgc.model.MgcPackageDetail;
import com.hawk.mgc.model.SearchMgcPackageVo;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class PackageDetailRepositoryTests {

	private static final String EXPECT_PRODUCT = "testProduct";

	Logger LOGGER = LoggerFactory.getLogger(PackageDetailRepositoryTests.class);

	@Autowired
	protected PackageDetailRepository packageDetailRepository;
	@Autowired
	protected PackageRepository packageRepository;

	private SearchMgcPackageVo searchMgcPackageVo;

	private MgcPackage mgcPackage;

	private MgcPackageDetail detail;

	@Test
	public void test() {

		packageDetailRepository.findByPackageId(0);
		packageDetailRepository.findByPackageId(null);

	}

	@Test
	public void shouldSearchPackageDetails() {
		givenASavedPackageDetail();
		searchMgcPackageVo = new SearchMgcPackageVo.Builder().build();
		List<MgcPackageDetail> l = packageDetailRepository
				.searchPackageDetails(searchMgcPackageVo);

		assertTrue(l.size() > 0);
		LOGGER.info("size: " + l.size());
		LOGGER.info(l.toString());
	}

	@Test
	public void shouldSearchPackageDetailsWithPackage() {

		givenASavedPackageDetail();

		searchMgcPackageVo = new SearchMgcPackageVo.Builder().mgcPackage(
				mgcPackage).build();
		List<MgcPackageDetail> l = packageDetailRepository
				.searchPackageDetails(searchMgcPackageVo);

		assertTrue(l.size() > 0);
		LOGGER.info("size: " + l.size());
		LOGGER.info(l.toString());

	}

	@Test
	public void shouldSearchPackageDetailsWithProductName() {

		givenASavedPackageDetail();

		searchMgcPackageVo = new SearchMgcPackageVo.Builder().mgcProduct(
				EXPECT_PRODUCT).build();
		List<MgcPackageDetail> l = packageDetailRepository
				.searchPackageDetails(searchMgcPackageVo);

		assertTrue(l.size() > 0);
		LOGGER.info("size: " + l.size());
		LOGGER.info(l.toString());

	}

	@Test
	public void shouldSearchNoPackageDetailsWithProductName() {

		givenASavedPackageDetail();

		searchMgcPackageVo = new SearchMgcPackageVo.Builder().mgcProduct("t")
				.build();
		List<MgcPackageDetail> l = packageDetailRepository
				.searchPackageDetails(searchMgcPackageVo);

		assertTrue(l.size() == 0);
		LOGGER.info("size: " + l.size());
		LOGGER.info(l.toString());

	}

	@Test
	public void shouldSearchPackageDetailsWithDate() {

		givenASavedPackageDetail();

		searchMgcPackageVo = new SearchMgcPackageVo.Builder()
				.dateFrom(new Date(new Date().getTime() - 3600))
				.dateTo(new Date(new Date().getTime() + 3600)).build();
		List<MgcPackageDetail> l = packageDetailRepository
				.searchPackageDetails(searchMgcPackageVo);

		assertTrue(l.size() > 0);
		LOGGER.info("size: " + l.size());
		LOGGER.info(l.toString());

	}

	@Test
	public void shouldSearchPackageDetailsWithFullCondition() {

		givenASavedPackageDetail();

		searchMgcPackageVo = new SearchMgcPackageVo.Builder()
				.mgcPackage(mgcPackage).mgcProduct(EXPECT_PRODUCT)
				.dateFrom(new Date(new Date().getTime() - 3600))
				.dateTo(new Date(new Date().getTime() + 3600)).build();
		List<MgcPackageDetail> l = packageDetailRepository
				.searchPackageDetails(searchMgcPackageVo);

		assertTrue(l.size() > 0);
		LOGGER.info("size: " + l.size());
		LOGGER.info(l.toString());

	}

	@Test
	public void shouldSavePackageDetail() {
		givenASavedPackageDetail();

		List<MgcPackageDetail> l = packageDetailRepository.findAll();

		assertTrue(l.size() > 0);
		LOGGER.info("size: " + l.size());
		LOGGER.info(l.toString());
	}

	private void givenASavedPackageDetail() {
		mgcPackage = new MgcPackage();
		mgcPackage.setPackageName("testPackage");
		mgcPackage.setProductionName(EXPECT_PRODUCT);
		packageRepository.save(mgcPackage);

		detail = new MgcPackageDetail();
		detail.setMgcPackage(mgcPackage);
		detail.setDetailDate(new Date());
		detail.setInstallations(100);
		detail.setActivations(100);

		packageDetailRepository.save(detail);

	}
}