package com.hawk.application.service;

import java.util.List;
import com.hawk.application.model.Dictionary;

public interface DictionaryService {

	List<Dictionary> getProvinces();
	List<Dictionary> getCitys(Dictionary province);
}
