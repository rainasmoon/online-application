package com.rainasmoon.onepay.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BidRestful {

	@RequestMapping("/bid")
	public String greeting(@RequestParam(value = "money", defaultValue = "1") Integer money) {
		return "add money success" + money;
	}
}
