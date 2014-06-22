package com.hawk.mgc.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.mgc.model.MgcPackageDetail;
import com.hawk.mgc.service.PackageService;

@Controller
@SessionAttributes(types = MgcPackageDetail.class)
public class PackageDetailController {

	Logger LOGGER = LoggerFactory.getLogger(PackageController.class);
	private final PackageService packageService;

	@Autowired
	public PackageDetailController(PackageService packageService) {
		this.packageService = packageService;
	}

	@RequestMapping(value = "packages/{mgcPackageId}/listDetails", method = RequestMethod.GET)
	public String processFindPackageDetails(
			@PathVariable("mgcPackageId") int mgcPackageId,
			Map<String, Object> model) {
		LOGGER.debug("the mgcpackageid is" + mgcPackageId);
		List<MgcPackageDetail> results = this.packageService
				.findPackageDetails(mgcPackageId);
		model.put("selections", results);
		return "package/listPackageRecords";
	}

	@RequestMapping(value = "packages/{mgcPackageId}/listDetails/new", method = RequestMethod.GET)
	public String initDetailCreationForm(Map<String, Object> model) {
		MgcPackageDetail mgcPackageDetail = new MgcPackageDetail();
		model.put("mgcPackageDetail", mgcPackageDetail);

		return "package/createOrUpdatePackageDetails";
	}

	@RequestMapping(value = "packages/{mgcPackageId}/listDetails/new", method = RequestMethod.POST)
	public String processDetailCreationForm(
			@PathVariable("mgcPackageId") int mgcPackageId,
			@Valid MgcPackageDetail mgcPackageDetail, BindingResult result,
			Map<String, Object> model) {
		if (result.hasErrors()) {
			return "package/createOrUpdatePackageDetails";
		} else {
			this.packageService.savePackageDetail(mgcPackageId,
					mgcPackageDetail);
			model.put("message", "save successfully.");
			return "redirect:/packages/" + mgcPackageId + "/listDetails/new";
		}
	}

	@RequestMapping(value = "packages/{mgcPackageId}/listDetails/{detailId}/edit", method = RequestMethod.GET)
	public String initDetailUpdateForm(
			@PathVariable("mgcPackageId") int mgcPackageId,
			@PathVariable("detailId") int detailId, Map<String, Object> model) {
		MgcPackageDetail mgcPackageDetail = packageService
				.findPackageDetailById(detailId);
		LOGGER.debug("the mgcPackage before is" + mgcPackageDetail);
		model.put("mgcPackageDetail", mgcPackageDetail);

		return "package/createOrUpdatePackageDetails";
	}

	@RequestMapping(value = "packages/{mgcPackageId}/listDetails/{detailId}/edit", method = RequestMethod.POST)
	public String processDetailUpdateForm(
			@PathVariable("mgcPackageId") int mgcPackageId,
			@Valid MgcPackageDetail mgcPackageDetail, BindingResult result) {
		LOGGER.debug("the mgcPackageDetail is" + mgcPackageDetail);
		if (result.hasErrors()) {
			return "package/createOrUpdatePackageDetails";
		} else {
			this.packageService.savePackageDetail(mgcPackageDetail);
			return "redirect:/packages/" + mgcPackageId + "/listDetails";
		}
	}

	@RequestMapping(value = "packages/{mgcPackageId}/listDetails/{detailId}/delete", method = RequestMethod.GET)
	public String deleteDetail(@PathVariable("mgcPackageId") int mgcPackageId,
			@PathVariable("detailId") int detailId, Map<String, Object> model) {

		this.packageService.deletePackageDetailById(detailId);

		return processFindPackageDetails(mgcPackageId, model);
	}
}
