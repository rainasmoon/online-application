package com.rainasmoon.onepay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.repository.springdatajpa.DictionaryRepository;
import com.rainasmoon.onepay.model.Dictionary;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryRepository dictionaryRepository;

	@Override
	public List<Dictionary> getProvinces() {
		return dictionaryRepository.findProvinces();
	}

	@Override
	public List<Dictionary> getCitys(Dictionary province) {
		return dictionaryRepository.findCitys(province.getId());
	}

	@Override
	public List<Dictionary> getAllCitys() {
		return dictionaryRepository.findAllCitys();
	}

}
