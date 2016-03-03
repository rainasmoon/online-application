package com.rainasmoon.onepay.vo;

import java.util.List;

import com.rainasmoon.onepay.model.User;

public class ProductListPageVo {

	private int totalAmount;
	private int todayAmount;
	private int totalUserCount;
	private int onlineUserCount;
	private int totalGoodCount;

	private List<User> activeTop5Users;

	private List<ProductVo> products;

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTodayAmount() {
		return todayAmount;
	}

	public void setTodayAmount(int todayAmount) {
		this.todayAmount = todayAmount;
	}

	public int getTotalUserCount() {
		return totalUserCount;
	}

	public void setTotalUserCount(int totalUserCount) {
		this.totalUserCount = totalUserCount;
	}

	public int getOnlineUserCount() {
		return onlineUserCount;
	}

	public void setOnlineUserCount(int onlineUserCount) {
		this.onlineUserCount = onlineUserCount;
	}

	public int getTotalGoodCount() {
		return totalGoodCount;
	}

	public void setTotalGoodCount(int totalGoodCount) {
		this.totalGoodCount = totalGoodCount;
	}

	public List<User> getActiveTop5Users() {
		return activeTop5Users;
	}

	public void setActiveTop5Users(List<User> activeTop5Users) {
		this.activeTop5Users = activeTop5Users;
	}

	public List<ProductVo> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVo> products) {
		this.products = products;
	}

}
