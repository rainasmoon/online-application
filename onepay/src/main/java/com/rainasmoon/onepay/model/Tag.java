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
	private String type;
}
