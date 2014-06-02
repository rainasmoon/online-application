package com.hawk.application.service;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hawk.application.model.Application;
import com.hawk.application.repository.springdatajpa.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private ApplicationRepository applicationRepository;

	@Autowired
	public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;

	}

	@Transactional
	public void saveApplication(Application application)
			throws DataAccessException {
		// TODO create the coressponding data in redis.
		application.setDianjoyAppId(generateAppId());
		application.setCreatedDate(new Date());
		application.setUpdatedDate(application.getCreatedDate());
		application.setCreatedBy(0);
		application.setUpdatedBy(0);
		applicationRepository.save(application);

	}

	@Transactional(readOnly = true)
	public Collection<Application> findAllApplications()
			throws DataAccessException {

		return applicationRepository.findAll();
	}

	@Transactional
	public void deleteApplicationById(int applicationId) {
		applicationRepository.delete(applicationId);

	}

	public String generateAppId() {
		return UUID.randomUUID().toString();
	}

}
