package com.rainasmoon.weixin.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "text/plain;charset=UTF-8")

public class WeixinRestful {

	public static Logger LOGGER = LoggerFactory.getLogger(WeixinRestful.class);

	@RequestMapping("/restful/echo")
	public String echo(@RequestParam(value = "echostr") String echostr) {
		LOGGER.info("weixin check. echo: " + echostr);
		return echostr;
	}

}
