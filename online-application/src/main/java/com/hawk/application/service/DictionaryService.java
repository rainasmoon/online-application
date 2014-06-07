package com.hawk.application.service;

import java.util.Collection;
import java.util.List;
import com.hawk.application.model.Dictionary;

public interface DictionaryService {

	Collection<Dictionary> getProvinces();
	Collection<Dictionary> getCitys(Dictionary province);
}
