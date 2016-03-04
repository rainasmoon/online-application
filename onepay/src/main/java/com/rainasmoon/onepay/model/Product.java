package com.rainasmoon.onepay.model;

import java.util.List;

public class Product {

	private int id;
	private String name;
	private int price;
	private int currentBiderCount;
	private long currentBiderId;

	private List tags;
	private List picPath;

	// 定时秒杀拍；3天内拍；给个底价拍。
	private int saleModel;

	// 几成新？10：全新；1：1成新。
	private int aging;

	private String description;
}
