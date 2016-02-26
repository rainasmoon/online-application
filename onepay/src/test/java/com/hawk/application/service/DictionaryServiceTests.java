package com.hawk.application.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hawk.application.model.Dictionary;

@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class DictionaryServiceTests {

	Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceTests.class);

	@Autowired
	protected DictionaryService dictionaryService;

	private Dictionary province;

	@Test
	public void shouldGetProvinces() {
		assertNotNull(dictionaryService.getProvinces());
		LOGGER.info(dictionaryService.getProvinces().toString());

	}

	@Test
	public void shouldGetCitys() {
		province = new Dictionary();
		province.setId(1);
		assertNotNull(dictionaryService.getCitys(province));
		LOGGER.info(dictionaryService.getCitys(province).toString());

	}

}
