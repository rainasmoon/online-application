package com.hawk.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hawk.application.model.Dictionary;
import com.hawk.application.repository.springdatajpa.DictionaryRepository;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryRepository dictionaryRepository;

	@Override
	@Cacheable(value = "dictionarys")
	public List<Dictionary> getProvinces() {
		return dictionaryRepository.findProvinces();
	}

	@Override
	@Cacheable(value = "dictionarys")
	public List<Dictionary> getCitys(Dictionary province) {
		return dictionaryRepository.findCitys(province.getId());
	}

	@Override
	@Cacheable(value = "dictionarys")
	public List<Dictionary> getAllCitys() {
		return dictionaryRepository.findAllCitys();
	}

}
