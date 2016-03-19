package com.rainasmoon.onepay.model;

public class YunOrder extends BaseEntity {

	private Long userId;
	private Long dealerId;
	// buy or sell
	private Integer model;

	// tradeWay: 微信，支付宝，淘宝
	private Integer tradeWay;
	private Integer amount;
	private Integer price;
	// onsale; deal; done; fail
	private Integer status;

	private String verifyCode;

	private String description;

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
