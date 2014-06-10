package com.hawk.application.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hawk.application.model.AppParameter;
import com.hawk.application.model.Application;
import com.hawk.application.repository.springdatajpa.AppParameterRepository;
import com.hawk.application.repository.springdatajpa.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private ApplicationRepository applicationRepository;

	private AppParameterRepository appParameterRepository;

	@Autowired
	public ApplicationServiceImpl(ApplicationRepository applicationRepository,
			AppParameterRepository appParameterRepository) {
		this.applicationRepository = applicationRepository;
		this.appParameterRepository = appParameterRepository;

	}

	@Transactional
	public void saveApplication(Application application)
			throws DataAccessException {
		// TODO create the coressponding data in redis.
		application.setDianjoyAppId(generateAppId());
		application.setCreatedDate(new Date());
		application.setUpdatedDate(application.getCreatedDate());
		applicationRepository.save(application);

	}

	@Transactional(readOnly = true)
	public List<Application> findAllApplications() throws DataAccessException {

		return applicationRepository.findAll();
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
	public List<AppParameter> findAllAppParameters() {
		return appParameterRepository.findAll();
	}

}
