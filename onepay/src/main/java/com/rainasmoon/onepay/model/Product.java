package com.rainasmoon.onepay.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Integer price;
	@Column(name = "current_bider_count")
	private Integer currentBiderCount;
	@Column(name = "current_bider_id")
	private Integer currentBiderId;
	@Transient
	private List<Tag> tags;
	@Transient
	private List<String> picPath;

	// 定时秒杀拍；3天内拍；给个底价拍。
	@Column(name = "sale_model")
	private Integer saleModel;

	// 几成新？10：全新；1：1成新。
	@Column(name = "aging")
	private Integer aging;
	@Column(name = "description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCurrentBiderCount() {
		return currentBiderCount;
	}

	public void setCurrentBiderCount(Integer currentBiderCount) {
		this.currentBiderCount = currentBiderCount;
	}

	public Integer getCurrentBiderId() {
		return currentBiderId;
	}

	public void setCurrentBiderId(Integer currentBiderId) {
		this.currentBiderId = currentBiderId;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<String> getPicPath() {
		return picPath;
	}

	public void setPicPath(List<String> picPath) {
		this.picPath = picPath;
	}

	public Integer getSaleModel() {
		return saleModel;
	}

	public void setSaleModel(Integer saleModel) {
		this.saleModel = saleModel;
	}

	public Integer getAging() {
		return aging;
	}

	public void setAging(Integer aging) {
		this.aging = aging;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
