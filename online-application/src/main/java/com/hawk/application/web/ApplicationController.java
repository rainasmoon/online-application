package com.hawk.application.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.application.model.AppParameter;
import com.hawk.application.model.Application;
import com.hawk.application.service.ApplicationService;

@Controller
@SessionAttributes(types = Application.class)
public class ApplicationController {

	private final ApplicationService applicationService;

	@Autowired
	public ApplicationController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public String processFindAll(Map<String, Object> model) {

		List<Application> results = this.applicationService
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

		List<AppParameter> results = this.applicationService
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
