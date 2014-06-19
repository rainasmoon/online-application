package com.hawk.application.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SearchReportVoTest {

	@Test
	public void test() {
		SearchReportVo vo = new SearchReportVo.Builder().build();

		assertTrue(vo.isSelectedAllApp());
	}
}
