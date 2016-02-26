package com.rainasmoon.onepay.web;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.service.ApplicationService;
import com.rainasmoon.onepay.model.Application;

@Controller
public class ApplicationCreateController extends BaseController {

	private final ApplicationService applicationService;

	@Autowired
	public ApplicationCreateController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("platformTypes")
	public List<String> populatePlatformTypes() {
		return Arrays.asList("iso");
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
			this.applicationService.saveApplication(getLoginEmail(),
					application);
			return "redirect:/applications";
		}
	}

}
