package com.rainasmoon.onepay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.service.BidService;
import com.rainasmoon.onepay.util.CommonConstants;
import com.rainasmoon.onepay.web.BaseController;

@RestController
@RequestMapping(produces = "text/plain;charset=UTF-8")
public class BidRestful extends BaseController {

	@Autowired
	private BidService bidService;

	@RequestMapping("/restful/bid")
	public String bid(@RequestParam(value = "productId") Long productId,
			@RequestParam(value = "money", defaultValue = "1") Integer money) {
		if (getLoginUserId() == null) {
			return CommonConstants.NO_LOGIN_MSG;
		}
		Product product = bidService.bidAddMoney(getLoginUserId(), productId,
				money);
		return product.getPrice().toString();
	}

	@RequestMapping("/restful/guess")
	public String guess(@RequestParam(value = "productId") Long productId,
			@RequestParam(value = "money") Integer money) {
		if (getLoginUserId() == null) {
			return CommonConstants.NO_LOGIN_MSG;
		}
		String result = bidService.guessMoney(getLoginUserId(), productId,
				money);
		return result;
	}

	@RequestMapping("/restful/generatebid/threedays")
	public String generateBidThreedays() {

		return bidService.generateBidThreeDays();
	}

	@RequestMapping("/restful/generatebid/threetimes")
	public String generateBidThreeTimes() {
		return bidService.generateBidThreeTimes();
	}
}
