package com.rainasmoon.onepay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "yunorders")
public class YunOrder extends BaseEntity {

	@Column(name = "user_id")
	private Long userId;
	@Column(name = "dealer_id")
	private Long dealerId;
	// buy or sell
	@Column(name = "model")
	private Integer model;

	// tradeWay: 微信，支付宝，淘宝
	@Column(name = "trade_way")
	private Integer tradeWay;
	@Column(name = "amount")
	private Integer amount;
	@Column(name = "price")
	private Integer price;
	// onsale; deal; done; fail
	@Column(name = "status")
	private Integer status;
	@Column(name = "verify_code")
	private String verifyCode;
	@Column(name = "description")
	private String description;

	public boolean isSell() {
		return model != null ? model.equals(2) : false;
	}

	public boolean isBuy() {
		return model != null ? model.equals(1) : false;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public Integer getTradeWay() {
		return tradeWay;
	}

	public void setTradeWay(Integer tradeWay) {
		this.tradeWay = tradeWay;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
