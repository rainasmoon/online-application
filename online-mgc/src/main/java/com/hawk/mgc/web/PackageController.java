package com.hawk.mgc.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.mgc.model.MgcPackage;
import com.hawk.mgc.model.SearchMgcPackageVo;
import com.hawk.mgc.service.PackageService;

@Controller
@SessionAttributes(types = SearchMgcPackageVo.class)
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

	@ModelAttribute("allMgcPackages")
	public List<MgcPackage> populateAllApplicationTypes() {

		List<MgcPackage> result = new ArrayList<MgcPackage>();
		MgcPackage all = new MgcPackage();
		all.setPackageName("全部");
		all.setProductionName("全部");
		result.add(all);
		result.addAll(packageService.findAllPackages());
		return result;
	}

	@ModelAttribute("productionTypes")
	public List<String> populateContactTypes() {
		return Arrays.asList("全部", "大家赚");
	}

	@RequestMapping(value = "/packages", method = RequestMethod.GET)
	public String processFindAll(Map<String, Object> model) {

		List<MgcPackage> results = this.packageService.findAllPackages();
		SearchMgcPackageVo searchMgcPackageVo = new SearchMgcPackageVo();
		model.put("searchMgcPackageVo", searchMgcPackageVo);
		model.put("selections", results);
		return "package/listChannel";

	}
}
