package com.rainasmoon.onepay.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Integer price;
	@Column(name = "owner_id")
	private Long ownerId;
	@Column(name = "current_bider_id")
	private Long currentBiderId;

	// 定时秒杀拍；3天内拍；给个底价拍。
	@Column(name = "sale_model")
	private Integer saleModel;

	@Column(name = "date_from")
	private Date dateFrom;
	@Column(name = "date_to")
	private Date dateTo;

	// 几成新？10：全新；1：1成新。
	@Column(name = "aging")
	private Integer aging;
	@Column(name = "description")
	private String description;

	public void addPrice(Integer addMoney) {
		price = price + addMoney;

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

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

}
