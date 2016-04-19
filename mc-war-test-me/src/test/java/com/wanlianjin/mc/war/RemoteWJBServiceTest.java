package com.wanlianjin.mc.war;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wanlianjin.mc.account.domain.WLGold;
import com.wanlianjin.mc.account.domain.WLGoldDetail;
import com.wanlianjin.mc.account.enums.WLGoldTypeEnum;
import com.wanlianjin.mc.account.service.proxy.AccountWLGoldService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:remoting-client.xml" })
@Rollback(true)
@Sql(value = { "classpath:insert-test-data.sql" }, config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--", dataSource = "dataSource", transactionManager = "transactionManager") )

public class RemoteWJBServiceTest {

	private static Logger log = LoggerFactory.getLogger(RemoteWJBServiceTest.class);

	private ApplicationContext context = new ClassPathXmlApplicationContext("/remoting-client.xml");

	private AccountWLGoldService accountWLGoldService = (AccountWLGoldService) context.getBean("wjbService");

	@Test
	public void testLog() {
		log.info("hi log...");
	}

	@Test
	public void shouldFindWJB() {
		WLGold r = accountWLGoldService.getGoldByUserId("testUserId");

		assertNotNull(r);
	}

	@Test
	public void shouldFindWJBWhenNull() {
		WLGold r = accountWLGoldService.getGoldByUserId("testUserId123");

		assertNotNull(r);
		assertEquals(0, r.getAmount().intValue());
	}

	@Test
	public void shoudUpdateWJBWhenRegister() {
		WLGold r = accountWLGoldService.getGoldByUserId("testUserId2");
		assertNotNull(r);
		assertEquals(0, r.getAmount().intValue());

		accountWLGoldService.updateGold(WLGoldTypeEnum.REGISTER_GOLD, "testUserId2", "testChannelId", "this is a test description");

		r = accountWLGoldService.getGoldByUserId("testUserId2");
		assertNotNull(r);
		assertNotNull(r.getAvailableAmount());
		assertEquals("should increase", 200, r.getAmount().intValue());

	}

	@Test
	public void shoudUpdateWJB() {
		accountWLGoldService.updateGold(WLGoldTypeEnum.REGISTER_GOLD, "testUserId", 100, "testChannelId", "this is a test");

		WLGold r = accountWLGoldService.getGoldByUserId("testUserId");
		assertNotNull(r);
		assertNotNull(r.getAvailableAmount());
		assertEquals("should increase", 600, r.getAvailableAmount().intValue());
	}

	@Test
	public void shouldFindWJBDetails() {
		String userId = "testUserId";
		Integer year = 2016;
		Integer month = 4;
		Integer day = 1;
		List<WLGoldDetail> r = accountWLGoldService.getWLGoldDetails(userId, year, month, day);

		assertNotNull(r);
		assertEquals(1, r.size());
	}

	@Test
	public void shouldFindWJBDetailsWithMonth() {
		String userId = "testUserId";
		Integer year = 2016;
		Integer month = 4;
		Integer day = null;
		List<WLGoldDetail> r = accountWLGoldService.getWLGoldDetails(userId, year, month, day);

		assertNotNull(r);
		assertEquals(1, r.size());
	}

	@Test
	public void shouldFindWJBDetailsIsNull() {
		String userId = "testUserId";
		Integer year = 2016;
		Integer month = 4;
		Integer day = 2;
		List<WLGoldDetail> r = accountWLGoldService.getWLGoldDetails(userId, year, month, day);

		assertNotNull(r);
		assertEquals(0, r.size());
	}

}
