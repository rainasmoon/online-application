package com.hawk.application.service;

import java.util.List;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hawk.application.model.AppParameter;
import com.hawk.application.model.Application;

public interface ApplicationService {

	void saveApplication(Application application) throws DataAccessException;

	List<Application> findAllApplications() throws DataAccessException;

	void deleteApplicationById(int applicationId) throws DataAccessException;

	String generateAppId();

	void deleteAppParameterById(int appParameterId);

	List<AppParameter> findAllAppParameters();

}
