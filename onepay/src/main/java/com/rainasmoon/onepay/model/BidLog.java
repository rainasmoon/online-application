package com.rainasmoon.onepay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bidlogs")
public class BidLog extends BaseEntity {

	@Column(name = "user_id")
	private Long userId;
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "price")
	private Integer price;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
