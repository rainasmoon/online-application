package com.rainasmoon.onepay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.service.BidService;
import com.rainasmoon.onepay.vo.BidRefreshVo;

@RestController
public class RefreshRestful {

	@Autowired
	private BidService bidService;

	@RequestMapping(value = "/restful/bid/refresh")
	@ResponseBody
	public BidRefreshVo refreshBid(@RequestParam(value = "productId") Long productId) {
		return bidService.getBidRefreshVo(productId);
	}
}
