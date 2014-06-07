package com.hawk.application.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hawk.application.model.Dictionary;
import com.hawk.application.repository.springdatajpa.DictionaryRepository;


@Service
public class DictionaryServiceImpl implements DictionaryService {
	
	@Autowired
	private DictionaryRepository dictionaryRepository;

	@Override
	public Collection<Dictionary> getProvinces() {
		return dictionaryRepository.findProvinces();
	}

	@Override
	public Collection<Dictionary> getCitys(Dictionary province) {
		return dictionaryRepository.findCitys(province.getId());
	}

	@Override
	public Collection<Dictionary> getAllCitys() {
		return dictionaryRepository.findAllCitys();
	}

}
