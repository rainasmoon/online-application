package com.rainasmoon.onepay.vo;


public class BidRefreshVo {

	private Integer bidersCount;
	private String currentOwer;
	private Integer price;
	private String status;

	public Integer getBidersCount() {
		return bidersCount;
	}

	public void setBidersCount(Integer bidersCount) {
		this.bidersCount = bidersCount;
	}

	public String getCurrentOwer() {
		return currentOwer;
	}

	public void setCurrentOwer(String currentOwer) {
		this.currentOwer = currentOwer;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
