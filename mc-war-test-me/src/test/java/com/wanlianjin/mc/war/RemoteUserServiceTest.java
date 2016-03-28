
package com.wanlianjin.mc.war;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
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

import com.kahadb.utility.exception.ApplicationException;
import com.kahadb.utility.exception.ParameterException;
import com.wanlianjin.mc.user.domian.UserLogin;
import com.wanlianjin.mc.user.dto.UserDto;
import com.wanlianjin.mc.user.enums.ChannelEnum;
import com.wanlianjin.mc.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:remoting-client-sit.xml", "classpath*:app-db-test.xml" })
@Rollback(true)
@Sql(value = { "classpath:insert-test-data.sql" }, config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--", dataSource = "dataSource", transactionManager = "transactionManager") )

public class RemoteUserServiceTest {

	private static Logger log = LoggerFactory.getLogger(RemoteUserServiceTest.class);

	private ApplicationContext context = new ClassPathXmlApplicationContext("/remoting-client.xml");

	private UserService userService = (UserService) context.getBean("userService");

	@Before
	public void setup() {
	}

	@After
	public void clear() {
	}

	@Test
	public void testAdd() {
		UserDto userDto = new UserDto();
		userDto.setUserId("11112");
		userDto.setUserAccount("test");
		userDto.setPassword("111");
		userDto.setMobilePhone("13690000123");
		userDto.setStatus(1);
		userDto.setEnChannel(ChannelEnum.WANLIAN);
		userDto.setChannelUserId("testChannelUserId");
		userDto.setCreateDate(new Date());
		String userId = userService.add(userDto, "", "");
		System.out.println(userId);
	}

	@Test
	public void testAdd100Times() {
		for (int i = 0; i < 1000; i++) {
			final int iid = i;
			final UserService fus = userService;

			for (int j = 0; j < 1000; j++) {
				System.out.println("T:" + iid + " for: " + j);
				UserDto userDto = new UserDto();
				userDto.setUserId("12117" + iid + j);
				userDto.setUserAccount("Auto7test" + iid + j);
				userDto.setPassword("111");
				userDto.setMobilePhone("1390070" + iid + j);
				userDto.setStatus(1);
				userDto.setEnChannel(ChannelEnum.WANLIAN);
				userDto.setChannelUserId("testChannelUserId");
				userDto.setCreateDate(new Date());
				String userId = fus.add(userDto, "", "");
				System.out.println("save success" + iid + ":" + j);
			}
		}

	}

	@Test
	public void testAdd100time100Times() {
		for (int i = 0; i < 100; i++) {
			final int iid = i;
			final UserService fus = userService;
			Thread t = new Thread() {
				@Override
				public void run() {

					for (int j = 0; j < 100; j++) {
						System.out.println("T:" + iid + " for: " + j);
						UserDto userDto = new UserDto();
						userDto.setUserId("12112" + j);
						userDto.setUserAccount("Autotest" + iid + j);
						userDto.setPassword("111");
						userDto.setMobilePhone("1390000" + iid + j);
						userDto.setStatus(1);
						userDto.setEnChannel(ChannelEnum.WANLIAN);
						userDto.setChannelUserId("testChannelUserId");
						userDto.setCreateDate(new Date());
						String userId = fus.add(userDto, "", "");
						System.out.println("save success" + iid + ":" + j);
					}
				}
			};
			t.start();
		}

	}

	@Test
	public void testAddWithRecordLoginInfo() {
		UserDto userDto = new UserDto();
		userDto.setUserId("11112");
		userDto.setUserAccount("test");
		userDto.setPassword("111");
		userDto.setMobilePhone("13690000123");
		userDto.setStatus(1);
		userDto.setEnChannel(ChannelEnum.WANLIAN);
		userDto.setChannelUserId("testChannelUserId");
		userDto.setCreateDate(new Date());
		String userId = userService.add(userDto, "1.1.0.1", "testData");
		assertNotNull(userId);

		UserDto r = userService.getByUserId(userId);
		assertNotNull(r);

	}

	@Test
	public void testAddThirdUser() {
		UserDto userDto = new UserDto();
		userDto.setUserId("11112");
		userDto.setUserAccount("testThirdAccount");
		userDto.setPassword("111");
		userDto.setMobilePhone("1369");
		userDto.setStatus(1);
		userDto.setEnChannel(ChannelEnum.WEIXIN);
		userDto.setChannelUserId("testChannelUserId");
		userDto.setCreateDate(new Date());
		String userId = userService.addThirdUser(userDto);
		log.info("add third user success.");
		log.info(userId);
		assertNotNull(userId);

		UserDto r = userService.getByUserId(userId);
		assertNotNull(r);

	}

	@Test(expected = ApplicationException.class)
	public void testAddThirdUserWithExistException() {
		UserDto userDto = new UserDto();
		userDto.setUserId("11112");
		userDto.setUserAccount("testThirdAccount");
		userDto.setPassword("111");
		userDto.setMobilePhone("1369");
		userDto.setStatus(1);
		userDto.setEnChannel(ChannelEnum.WEIXIN);
		userDto.setChannelUserId("testChannelUserId");
		userDto.setCreateDate(new Date());
		userService.addThirdUser(userDto);
		userService.addThirdUser(userDto);
		log.info("add third user success.");
	}

	@Test
	public void login() {
		UserDto userDto = userService.login("testGlen", "111111");
		assertNotNull(userDto);
		assertEquals("testGlen", userDto.getUserAccount());
	}

	@Test
	public void login_v2() {
		UserDto userDto = userService.login("testGlen", "111111", "127.0.0.1", "rewfr345red");

		assertNotNull(userDto);
		assertEquals("testGlen", userDto.getUserAccount());
	}

	@Test
	public void existAccountName() {
		Boolean flag = userService.existAccountName("test1");
		System.out.println(flag);
	}

	@Test
	public void existMobile() {
		Boolean flag = userService.existMobile("13456781234");
		assertTrue(flag);
	}

	@Test
	public void shouldLoginThirdChannelUser() {
		UserDto userDto = new UserDto();
		userDto.setEnChannel(ChannelEnum.CICPROPERTY);
		userDto.setChannelUserId("test3rdUserid_1");

		UserLogin userLogin = new UserLogin();
		userLogin.setLastLoginAppnum("test3rdloginappclient");
		userDto.setUserLogin(userLogin);

		String r = userService.login3rdUser(userDto);
		assertNotNull(r);

		r = userService.login3rdUser(userDto);
		assertNotNull(r);

		UserDto result = userService.getByUserId(r);
		assertNotNull(result);

	}

	@Test
	public void shouldLoginThirdChannelUser_v2() {
		UserDto userDto = new UserDto();
		userDto.setEnChannel(ChannelEnum.CICPROPERTY);
		userDto.setChannelUserId("test3rdUserid_1");

		String r = userService.login3rdUser(userDto, "1.1.2.4", "test3rdloginappclient");
		assertNotNull(r);

		r = userService.login3rdUser(userDto, "1.1.2.4", "test3rdloginappclient");
		assertNotNull(r);

		UserDto result = userService.getByUserId(r);
		assertNotNull(result);

	}

	@Test(expected = ParameterException.class)
	public void existMobileWithPhoneException() {
		Boolean flag = userService.existMobile("13456");
		assertTrue(flag);
	}

	@Test
	public void testUpdate() {
		UserDto userDto = new UserDto();
		userDto.setUserId("11112");
		userDto.setStatus(1);
		// userDto.setEnChannel(ChannelEnum.WANLIAN);
		userDto.setCreateDate(new Date());
		userService.update(userDto);
		System.out.println(1);
	}

	@Test
	public void testCheckPassword() {
		boolean flag = userService.checkPassword("111112", "111");
		System.out.println(flag);
	}

	@Test
	public void testUpdatePassWord() {
		boolean flag = userService.updatePassword("11112", "111111", "222222");
		assertTrue(flag);

		flag = userService.updatePassword("11112", "111111", "222222");
		assertFalse(flag);

		UserDto user = userService.login("testGlen", "111111", "testIp", "testLoginapp");
		assertNull(user);

		user = userService.login("testGlen", "222222", "testIp", "testLoginapp");
		assertNotNull(user);
		assertEquals("testGlen", user.getUserAccount());
	}

	@Test
	public void testResetPassWord() {
		boolean flag = userService.updatePassWord("11112", "222222");
		assertTrue(flag);

		UserDto user = userService.login("testGlen", "111111", "testIp", "testLoginapp");
		assertNull(user);

		user = userService.login("testGlen", "222222", "testIp", "testLoginapp");
		assertNotNull(user);
		assertEquals("testGlen", user.getUserAccount());
	}

	@Test
	public void testUpdateMobile() {
		boolean flag = userService.updateMobile("11112", "13456753567");
		System.out.println(flag);
	}

	@Test
	public void testGetByLoginName() {
		UserDto loginUser = userService.getByLoginName("testGlen");
		assertNotNull(loginUser);
		assertEquals("testGlen", loginUser.getUserAccount());
	}

	@Test
	public void testGetByChannelUserId() {
		UserDto userDto = userService.getByChannelUserId(ChannelEnum.WEIXIN, "testChannelUserId");
		assertNotNull(userDto);
		assertEquals("testChannelUserId", userDto.getChannelUserId());
	}

	@Test
	public void testGetByChannelUserIdIsNull() {
		UserDto userDto = userService.getByChannelUserId(ChannelEnum.WEIXIN, "testNotExistUserId");
		assertNull(userDto);

	}

	@Test
	public void testBindChannelUser() {
		userService.bindChannelUser(ChannelEnum.WEIXIN, "11112", "testWexinGlen");

		UserDto userDto = userService.getByChannelUserId(ChannelEnum.WEIXIN, "testWexinGlen");
		assertNotNull(userDto);
		assertEquals("testChannelUserId", userDto.getChannelUserId());
	}

	@Test
	public void testLog() {
		log.info("hi log...");
	}

}
