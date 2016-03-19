package com.rainasmoon.onepay.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "text/plain;charset=UTF-8")
public class OrderRestful {

	@RequestMapping("/restful/order_receive")
	public String orderReceive() {
		return "OK";
	}

	@RequestMapping("/restful/order_send")
	public String orderSend() {
		return "OK";
	}

}
