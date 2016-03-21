package com.rainasmoon.onepay.vo;

public class BidRefreshVo {

	private Integer bidersCount;
	private String currentOwerName;
	private Integer price;
	private String statusName;

	public Integer getBidersCount() {
		return bidersCount;
	}

	public void setBidersCount(Integer bidersCount) {
		this.bidersCount = bidersCount;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCurrentOwerName() {
		return currentOwerName;
	}

	public void setCurrentOwerName(String currentOwerName) {
		this.currentOwerName = currentOwerName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
