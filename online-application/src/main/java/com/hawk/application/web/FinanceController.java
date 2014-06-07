package com.hawk.application.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hawk.application.model.Application;
import com.hawk.application.model.User;
import com.hawk.application.service.ApplicationService;

import com.hawk.application.model.*;
import com.hawk.application.service.*;

@Controller
@SessionAttributes(types = Check.class)
public class FinanceController {
	
	
	private final FinanceService financeService;
	
	@Autowired
	public FinanceController(FinanceService financeService) {
		this.financeService = financeService;
	}

	@RequestMapping(value = "/checks/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		Check check = new Check();
		model.put("check", check);

		return "finance/applyCheck";
	}

	@RequestMapping(value = "/checks/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Check check,
			BindingResult result) {
		if (result.hasErrors()) {
			return "finance/applyCheck";
		} else {
			this.financeService.saveCheck(check);			
			return "redirect:/checks";
		}
	}

	@RequestMapping(value = "/checks", method = RequestMethod.GET)
	public String processFindAllChecks(Map<String, Object> model) {

		Collection<Check> results = this.financeService
				.findAllChecks();

		model.put("selections", results);
		return "finance/listCheck";

	}
	
	@RequestMapping(value = "/bonus", method = RequestMethod.GET)
	public String processFindAllBonus(Map<String, Object> model) {

		Collection<Bonus> results = this.financeService
				.findAllBonus();

		model.put("selections", results);
		return "finance/listBonus";

	}
}
