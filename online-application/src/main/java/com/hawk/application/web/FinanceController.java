package com.hawk.application.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hawk.application.model.Bonus;
import com.hawk.application.model.Check;
import com.hawk.application.model.User;
import com.hawk.application.service.FinanceService;
import com.hawk.application.service.RedisService;
import com.hawk.application.service.UserService;

@Controller
public class FinanceController extends BaseController {

	private final FinanceService financeService;
	@Autowired
	private UserService userService;

	@Autowired
	private RedisService redisService;

	@Autowired
	private Mapper dozerBeanMapper;

	@Autowired
	public FinanceController(FinanceService financeService) {
		this.financeService = financeService;
	}

	@RequestMapping(value = "/checks/new", method = RequestMethod.GET)
	public String initCreationForm(HttpSession session,
			Map<String, Object> model) {

		String userEmail = (String) session.getAttribute("userEmail");
		User user = userService.findUserByEmail(userEmail);

		Check check = dozerBeanMapper.map(user, Check.class);
		check.setId(null);
		check.setRemainder(redisService.getUserTotalIncome(getLoginEmail()));

		model.put("check", check);
		return "finance/applyCheck";
	}

	@RequestMapping(value = "/checks/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Check check, BindingResult result) {
		new CheckValidator()
				.validate(redisService.getUserTotalIncome(getLoginEmail()),
						check, result);
		if (result.hasErrors()) {
			return "finance/applyCheck";
		} else {
			this.financeService.saveCheck(getLoginEmail(), check);
			return "redirect:/checks";
		}
	}

	@RequestMapping(value = "/checks", method = RequestMethod.GET)
	public String processFindAllChecks(Map<String, Object> model) {

		List<Check> results = this.financeService
				.findAllChecks(getLoginEmail());

		model.put("selections", results);
		return "finance/listCheck";

	}

	@RequestMapping(value = "/bonus", method = RequestMethod.GET)
	public String processFindAllBonus(Map<String, Object> model) {

		List<Bonus> results = this.financeService.findAllBonus(getLoginEmail());

		model.put("selections", results);
		return "finance/listBonus";

	}
}
