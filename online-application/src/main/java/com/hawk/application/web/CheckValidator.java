package com.hawk.application.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;

import com.hawk.application.model.Check;

public class CheckValidator {
	Logger LOGGER = LoggerFactory.getLogger(CheckValidator.class);

	public void validate(double remainder, Check check, Errors errors) {

		if (check.getApplyAmount() > remainder) {
			errors.rejectValue("applyAmount", "error.check.amount.too.big");
		}

	}
}
