package com.rainasmoon.onepay.web;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;

import com.rainasmoon.onepay.vo.AddProductVo;

public class ProductValidator {
	Logger LOGGER = LoggerFactory.getLogger(ProductValidator.class);

	public void validate(AddProductVo productVo, Errors errors) {

		if (StringUtils.isBlank(productVo.getProductName())) {
			errors.rejectValue("productName", "error.product.name.not.null");
		}

	}
}
