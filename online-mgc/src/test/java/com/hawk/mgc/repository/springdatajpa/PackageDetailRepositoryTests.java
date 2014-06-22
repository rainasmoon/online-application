package com.hawk.mgc.repository.springdatajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class PackageDetailRepositoryTests {

	@Autowired
	protected PackageDetailRepository packageDetailRepository;

	@Test
	public void test() {

		packageDetailRepository.findByPackageId(0);
		packageDetailRepository.findByPackageId(null);

	}
}