package com.rainasmoon.onepay.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.vo.BidRefreshVo;

@RestController
public class RefreshRestful {

	@RequestMapping(value = "/restful/bid/refresh")
	@ResponseBody
	public BidRefreshVo refreshBid(@RequestParam(value = "productId") Long productId) {
		return new BidRefreshVo();
	}
}
