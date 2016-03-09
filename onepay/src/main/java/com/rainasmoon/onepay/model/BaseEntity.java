package com.rainasmoon.onepay.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);

	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		BaseEntity that = (BaseEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null) {
			return false;
		}

		return true;

	}

	@Override
	public int hashCode() {

		return id != null ? id.hashCode() : 0;

	}

	public boolean isNew() {
		return (this.id == null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}