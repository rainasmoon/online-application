package com.hawk.application.web;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.application.model.Application;
import com.hawk.application.model.PlatformType;
import com.hawk.application.service.ApplicationService;

@Controller
@SessionAttributes(types = Application.class)
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
	public List<PlatformType> populatePlatformTypes() {
		return PlatformType.getAllPlatformTypes();
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
