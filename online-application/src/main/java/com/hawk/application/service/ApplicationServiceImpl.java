/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
		application.setApplicationId(generateAppId());
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
