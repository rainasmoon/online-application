package com.rainasmoon.onepay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.repository.springdatajpa.*;
import com.rainasmoon.onepay.model.Sdk;

@Service
public class SdkServiceImpl implements SdkService {

	@Autowired
	private SdkRepository sdkRepository;
	@Override
	public List<Sdk> findAllSdks() {
		
		return sdkRepository.findAll();
	}

}
