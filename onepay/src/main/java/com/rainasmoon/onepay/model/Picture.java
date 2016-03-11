package com.rainasmoon.onepay.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

	@Column(name = "product_id")
	private Long productId;
	@Column(name = "pic_path")
	private String picPath;
	@Column(name = "create_date")
	private Date createDate;

	public static Picture noPicture() {
		Picture picture = new Picture();
		picture.setPicPath("nopic");
		return picture;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
