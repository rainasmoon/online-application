package com.rainasmoon.onepay.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rainasmoon.onepay.enums.ProductStatus;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "original_price")
	private Integer originalPrice;
	@Column(name = "price")
	private Integer price;
	@Column(name = "owner_id")
	private Long ownerId;
	@Column(name = "current_bider_id")
	private Long currentBiderId;

	// 定时秒杀拍；3天内拍；给个底价拍。
	@Column(name = "sale_model")
	private Integer saleModel;

	// 几成新？10：全新；1：1成新。
	@Column(name = "aging")
	private Integer aging;
	@Column(name = "description")
	private String description;

	// 状态： 在售，成交，流拍，结束
	@Column(name = "status")
	private Integer status;

	@Column(name = "end_date")
	private Date endDate;

	public void addPrice(Integer addMoney) {
		price = price + addMoney;

	}

	public boolean isOnSale() {

		return ProductStatus.ONSALE.getCode().equals(status);
	}

	public String getStatusName() {
		return ProductStatus.valueOf(getStatus()).getName();
	}

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

	public Long getCurrentBiderId() {
		return currentBiderId;
	}

	public void setCurrentBiderId(Long currentBiderId) {
		this.currentBiderId = currentBiderId;
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

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

}
