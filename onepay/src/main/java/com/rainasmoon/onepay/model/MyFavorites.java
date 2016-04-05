package com.rainasmoon.onepay.model;

public class MyFavorites extends BaseEntity {

	private Long userId;
	private Long productId;

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

}
