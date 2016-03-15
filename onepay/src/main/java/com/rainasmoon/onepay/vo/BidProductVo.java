package com.rainasmoon.onepay.vo;

import java.util.Date;
import java.util.List;

public class BidProductVo {

	private Long productId;
	private String productTitle;
	private Integer bidersCount;
	private String currentOwer;
	private List<String> tags;
	private String description;
	private Integer originalPrice;
	private Integer price;
	private String picPath;
	private Date startTime;
	private Date endTime;

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getCurrentOwer() {
		return currentOwer;
	}

	public void setCurrentOwer(String currentOwer) {
		this.currentOwer = currentOwer;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getBidersCount() {
		return bidersCount;
	}

	public void setBidersCount(Integer bidersCount) {
		this.bidersCount = bidersCount;
	}

}
