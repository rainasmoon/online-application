package com.rainasmoon.onepay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.model.Tag;
import com.rainasmoon.onepay.service.TagService;
import com.rainasmoon.onepay.web.BaseController;

@RestController
public class TagRestful  extends BaseController{
	
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping("/saveUserTag")
	public String saveUserTag(@RequestParam(value = "value") String value) {
		Tag tag = tagService.addUserTag(getLoginUserId(), value);
		return value;
	}
}
