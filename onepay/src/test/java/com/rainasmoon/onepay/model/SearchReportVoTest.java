package com.rainasmoon.onepay.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rainasmoon.onepay.model.SearchReportVo;

public class SearchReportVoTest {

	@Test
	public void test() {
		SearchReportVo vo = new SearchReportVo.Builder().build();

		assertTrue(vo.isSelectedAllApp());
	}
}
