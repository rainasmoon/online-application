package com.hawk.application.web;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hawk.application.model.*;
import com.hawk.application.service.*;



@Controller
public class SdkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SdkController.class);

	private final SdkService sdkService;

	@Autowired
	public SdkController(SdkService sdkService) {
		this.sdkService = sdkService;
	}
    
    @RequestMapping(value = "/sdks", method = RequestMethod.GET)
	public String processFindAll(Map<String, Object> model) {

		List<Sdk> results = this.sdkService
				.findAllSdks();

		model.put("selections", results);
		return "sdk/listSDK";

	}
}