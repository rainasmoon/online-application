package com.hawk.application.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	protected Map<String, Object> referenceData() {

		Map<String, Object> referenceData = new HashMap<String, Object>();

		List<String> platformList = new ArrayList<String>();
		platformList.add("ios");

		referenceData.put("platformList", platformList);

		return referenceData;
	}

	@RequestMapping(value = "/applications/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		Application application = new Application();
		model.put("application", application);
		model.putAll(referenceData());
		return "application/createApplication";
	}

	@RequestMapping(value = "/applications/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Application application,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "application/createApplication";
		} else {
			this.applicationService.saveApplication(application);
			status.setComplete();
			return "redirect:/applications";
		}
	}

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public String processFindAll(Map<String, Object> model) {

		// find owners by last name
		Collection<Application> results = this.applicationService
				.findAllApplications();

		// multiple owners found
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

}
