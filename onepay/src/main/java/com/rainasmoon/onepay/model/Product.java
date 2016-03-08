package com.rainasmoon.onepay.model;

import java.util.List;

public class Product extends BaseEntity {

	private String name;
	private Integer price;
	private Integer currentBiderCount;
	private Integer currentBiderId;

	private List<Tag> tags;
	private List<String> picPath;

	// 定时秒杀拍；3天内拍；给个底价拍。
	private Integer saleModel;

	// 几成新？10：全新；1：1成新。
	private Integer aging;

	private String description;
}
