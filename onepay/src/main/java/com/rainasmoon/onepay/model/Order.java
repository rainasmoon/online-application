package com.rainasmoon.onepay.model;

import java.util.Date;

public class Order extends BaseEntity {

	private Long userId;
	private Long productId;
	private Integer price;
	private Integer status;
	private Date createTime;
}
