package com.rainasmoon.onepay.model;

public class YunOrder extends BaseEntity {

	private Long userId;
	private Long dealerId;
	// buy or sell
	private Integer model;

	private Integer amount;
	private Integer price;
	// onsale; deal; done; fail
	private Integer status;

}
