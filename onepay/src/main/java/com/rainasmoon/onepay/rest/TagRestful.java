package com.rainasmoon.onepay.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.web.BaseController;

@RestController
public class TagRestful  extends BaseController{
	@RequestMapping("/saveUserTag")
	public String saveUserTag(@RequestParam(value = "value") String value) {
		
		return value;
	}
}
