package com.hawk.mgc.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.mgc.model.MgcPackage;
import com.hawk.mgc.service.PackageService;

@Controller
@SessionAttributes(types = MgcPackage.class)
public class PackageController {

	Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final PackageService packageService;

	@Autowired
	public PackageController(PackageService packageService) {
		this.packageService = packageService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/packages", method = RequestMethod.GET)
	public String processFindAll(Map<String, Object> model) {

		List<MgcPackage> results = this.packageService.findAllPackages();

		model.put("selections", results);
		return "package/listChannel";

	}
}
