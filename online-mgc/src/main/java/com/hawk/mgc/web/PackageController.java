package com.hawk.mgc.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.mgc.model.MgcPackage;
import com.hawk.mgc.model.MgcPackageDetail;
import com.hawk.mgc.model.SearchMgcPackageVo;
import com.hawk.mgc.service.PackageService;

@Controller
@SessionAttributes(types = MgcPackage.class)
public class PackageController {

	Logger LOGGER = LoggerFactory.getLogger(PackageController.class);
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
		result.add(all);
		result.addAll(packageService.findAllPackages());
		return result;
	}

	@ModelAttribute("productionTypes")
	public List<String> populateContactTypes() {
		return Arrays.asList("大家赚");
	}

	@RequestMapping(value = "/packages", method = RequestMethod.GET)
	public String processFindAllPackages(Map<String, Object> model) {
		List<MgcPackage> results = this.packageService.findAllPackages();
		model.put("selections", results);
		return "package/listPackage";

	}

	@RequestMapping(value = "/channels", method = RequestMethod.GET)
	public String processFindAll(Map<String, Object> model) {
		SearchMgcPackageVo searchMgcPackageVo = new SearchMgcPackageVo();
		model.put("searchMgcPackageVo", searchMgcPackageVo);
		return "package/listChannel";

	}

	@RequestMapping(value = "/channels", method = RequestMethod.POST)
	public String processSearchAll(SearchMgcPackageVo searchMgcPackageVo,
			Map<String, Object> model) {

		List<MgcPackageDetail> results = this.packageService
				.searchPackageDetails(searchMgcPackageVo);

		model.put("selections", results);
		return "package/listChannel";

	}

	@RequestMapping(value = "/packages/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		MgcPackage mgcPackage = new MgcPackage();
		model.put("mgcPackage", mgcPackage);

		return "package/createOrUpdatePackage";
	}

	@RequestMapping(value = "/packages/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid MgcPackage mgcPackage,
			BindingResult result) {
		if (result.hasErrors()) {
			return "package/createOrUpdatePackage";
		} else {
			this.packageService.savePackage(mgcPackage);
			return "redirect:/packages";
		}
	}

	@RequestMapping(value = "/packages/{packageId}/edit", method = RequestMethod.GET)
	public String initUpdateForm(@PathVariable("packageId") int packageId,
			Map<String, Object> model) {
		MgcPackage mgcPackage = packageService.findPackageById(packageId);
		LOGGER.debug("the mgcPackage before is" + mgcPackage);
		model.put("mgcPackage", mgcPackage);

		return "package/createOrUpdatePackage";
	}

	@RequestMapping(value = "/packages/{packageId}/edit", method = RequestMethod.POST)
	public String processUpdateForm(@Valid MgcPackage mgcPackage,
			BindingResult result) {
		LOGGER.debug("the mgcPackage is" + mgcPackage);
		if (result.hasErrors()) {
			return "package/createOrUpdatePackage";
		} else {
			this.packageService.savePackage(mgcPackage);
			return "redirect:/packages";
		}
	}

	@RequestMapping(value = "/packages/{packageId}/delete", method = RequestMethod.GET)
	public String deletePackage(@PathVariable("packageId") int packageId,
			Map<String, Object> model) {

		this.packageService.deletePackageById(packageId);

		return processFindAll(model);
	}

}
