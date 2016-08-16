package com.rainasmoon.onepay.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rainasmoon.onepay.model.Feedback;
import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.service.FeedbackService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.util.HttpUtils;

@Controller
public class HelpController extends BaseController {

	public static Logger LOGGER = LoggerFactory.getLogger(HelpController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(value = { "/help.html" }, method = RequestMethod.GET)
	public String help(Map<String, Object> model) {

		return "help";
	}

	@RequestMapping(value = { "/agreement.html" }, method = RequestMethod.GET)
	public String agreement(Map<String, Object> model) {

		return "agreement";
	}

	@RequestMapping(value = { "/feedback.html" }, method = RequestMethod.GET)
	public String showFeedback(Map<String, Object> model) {

		model.put("feedback", new Feedback());
		return "feedback";
	}

	@RequestMapping(value = { "/feedback.html" }, method = RequestMethod.POST)
	public String feedback(Feedback feedback, BindingResult result, Map<String, Object> model) {

		if (StringUtils.isBlank(feedback.getContent())) {
			result.rejectValue("content", "NotEmpty.loginVo.account");
		}

		if (result.hasErrors()) {
			LOGGER.warn("field error. when submiting feedback.");
			LOGGER.debug(result.toString());
			return "feedback";
		}

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		feedback.setIp(HttpUtils.getIpAddr(request));
		feedback.setAgent(HttpUtils.getAgent(request));

		if (isLogin()) {
			feedback.setUserId(getLoginUserId());
			User loginUser = userService.findUser(getLoginUserId());

			if (loginUser != null) {
				feedback.setEmail(loginUser.getEmail());
				feedback.setPhone(loginUser.getPhone());
				feedback.setName(loginUser.getShowName());
			}

		}

		String message = feedbackService.addFeedback(feedback);
		model.put("message", message);
		return "feedback";
	}
}
