package com.hawk.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hawk.application.model.Sdk;
import com.hawk.application.repository.springdatajpa.*;

@Service
public class SdkServiceImpl implements SdkService {

	@Autowired
	private SdkRepository sdkRepository;
	@Override
	public List<Sdk> findAllSdks() {
		
		return sdkRepository.findAll();
	}

}
