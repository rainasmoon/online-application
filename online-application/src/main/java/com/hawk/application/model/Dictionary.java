package com.hawk.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dictionary")
public class Dictionary  extends BaseEntity {

	@Column(name = "data_type")
	protected String dataType;
	
	@Column(name = "dictionary_key")
	protected Integer dictionaryKey;
	
	@Column(name = "dictionary_value")
	protected String dictionaryValue;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getDictionaryKey() {
		return dictionaryKey;
	}

	public void setDictionaryKey(Integer dictionaryKey) {
		this.dictionaryKey = dictionaryKey;
	}

	public String getDictionaryValue() {
		return dictionaryValue;
	}

	public void setDictionaryValue(String dictionaryValue) {
		this.dictionaryValue = dictionaryValue;
	}
	
}
