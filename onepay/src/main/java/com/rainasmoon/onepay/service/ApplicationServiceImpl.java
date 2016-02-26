package com.rainasmoon.onepay.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainasmoon.onepay.repository.springdatajpa.AppParameterRepository;
import com.rainasmoon.onepay.repository.springdatajpa.ApplicationRepository;
import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.web.ImageController;
import com.rainasmoon.onepay.model.AppParameter;
import com.rainasmoon.onepay.model.Application;
import com.rainasmoon.onepay.model.User;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ImageController.class);

	private ApplicationRepository applicationRepository;

	private AppParameterRepository appParameterRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	public ApplicationServiceImpl(ApplicationRepository applicationRepository,
			AppParameterRepository appParameterRepository) {
		this.applicationRepository = applicationRepository;
		this.appParameterRepository = appParameterRepository;

	}

	@Transactional
	public void saveApplication(String email, Application application)
			throws DataAccessException {
		// TODO create the coressponding data in redis.
		application.setDianjoyAppId(generateAppId());
		application.setCreatedDate(new Date());
		application.setUpdatedDate(application.getCreatedDate());
		LOGGER.debug("the email is when save:" + email);
		User loginUser = userRepository.findByEmail(email);
		if (loginUser != null) {
			Integer createdBy = loginUser.getId();
			application.setCreatedBy(createdBy);
			application.setUpdatedBy(createdBy);
		}
		applicationRepository.save(application);

	}

	@Transactional(readOnly = true)
	public List<Application> findAllApplications(String email)
			throws DataAccessException {

		Integer createdBy = userRepository.findByEmail(email).getId();
		return applicationRepository.findByCreatedBy(createdBy);
	}

	@Transactional
	public void deleteApplicationById(int applicationId) {
		applicationRepository.delete(applicationId);

	}

	public String generateAppId() {
		return UUID.randomUUID().toString();
	}

	@Transactional
	public void deleteAppParameterById(int appParameterId) {
		appParameterRepository.delete(appParameterId);

	}

	@Transactional(readOnly = true)
	public List<AppParameter> findAllAppParameters(String email) {
		Integer createdBy = userRepository.findByEmail(email).getId();
		return appParameterRepository.findByCreatedBy(createdBy);
	}

}
