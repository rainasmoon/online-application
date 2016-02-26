package com.rainasmoon.onepay.model;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rainasmoon.onepay.model.Check;

public class CheckValidationTest {

	Logger LOGGER = LoggerFactory.getLogger(CheckValidationTest.class);

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void checkNullMessage() {
		Check check = new Check();

		Set<ConstraintViolation<Check>> constraintViolations = validator
				.validate(check);
		LOGGER.info(constraintViolations.toString());
		assertEquals(1, constraintViolations.size());
		assertEquals("may not be null", constraintViolations.iterator().next()
				.getMessage());
	}

	@Test
	public void checkPassMessage() {
		Check check = new Check();
		check.setApplyAmount(123.689);

		Set<ConstraintViolation<Check>> constraintViolations = validator
				.validate(check);
		LOGGER.info(constraintViolations.toString());
		assertEquals(0, constraintViolations.size());

	}

}
