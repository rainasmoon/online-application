package com.hawk.application.web;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.support.SessionStatus;

import com.hawk.application.model.AppParameter;
import com.hawk.application.model.Application;
import com.hawk.application.model.PlatformType;
import com.hawk.application.service.ApplicationService;

@Controller
@SessionAttributes(types = Application.class)
public class ApplicationController {

	private final ApplicationService applicationService;

	@Autowired
	public ApplicationController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("platformTypes")
	public Collection<PlatformType> populatePlatformTypes() {
		return Arrays.asList(new PlatformType("iso"));
	}

	@RequestMapping(value = "/applications/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		Application application = new Application();
		model.put("application", application);

		return "application/createApplication";
	}

	@RequestMapping(value = "/applications/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Application application,
			BindingResult result) {
		if (result.hasErrors()) {
			return "application/createApplication";
		} else {
			this.applicationService.saveApplication(application);			
			return "redirect:/applications";
		}
	}

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public String processFindAll(Map<String, Object> model) {

		Collection<Application> results = this.applicationService
				.findAllApplications();

		model.put("selections", results);
		return "application/listApplication";

	}

	@RequestMapping(value = "/applications/{applicationId}/delete", method = RequestMethod.GET)
	public String deleteApplication(
			@PathVariable("applicationId") int applicationId,
			Map<String, Object> model) {

		this.applicationService.deleteApplicationById(applicationId);

		return processFindAll(model);
	}

	@RequestMapping(value = "/applications/parameters", method = RequestMethod.GET)
	public String processFindAllParameters(Map<String, Object> model) {

		Collection<AppParameter> results = this.applicationService
				.findAllAppParameters();

		model.put("selections", results);
		return "application/listAppParameter";

	}

	@RequestMapping(value = "/applications/parameters/{appParameterId}/delete", method = RequestMethod.GET)
	public String deleteAppParameter(
			@PathVariable("appParameterId") int appParameterId,
			Map<String, Object> model) {

		this.applicationService.deleteAppParameterById(appParameterId);

		return processFindAllParameters(model);
	}

}
