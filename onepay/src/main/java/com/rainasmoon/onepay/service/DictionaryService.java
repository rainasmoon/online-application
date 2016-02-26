package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Dictionary;

public interface DictionaryService {

	List<Dictionary> getProvinces();
	List<Dictionary> getCitys(Dictionary province);
	List<Dictionary> getAllCitys();
}
