package com.rainasmoon.onepay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag extends BaseEntity {

	@Column(name = "obj_id")
	private Long objId;
	@Column(name = "name")
	private String name;

	// for user, for product.
	@Column(name = "tag_type")
	private Integer type;

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
