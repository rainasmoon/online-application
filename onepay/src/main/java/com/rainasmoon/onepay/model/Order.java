package com.rainasmoon.onepay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@Column(name = "saler_id")
	private Long salerId;
	@Column(name = "buyer_id")
	private Long buyerId;
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "price")
	private Integer price;
	@Column(name = "sender_name")
	private String senderName;
	@Column(name = "sender_phone")
	private String senderPhone;
	@Column(name = "sender_address")
	private String senderAddress;
	@Column(name = "sender_postcode")
	private String senderPostcode;
	@Column(name = "receiver_name")
	private String receiverName;
	@Column(name = "receiver_phone")
	private String receiverPhone;
	@Column(name = "receiver_address")
	private String receiverAddress;
	@Column(name = "receiver_postcode")
	private String receiverPostcode;

	// 待支付，待发货，完成，失败
	@Column(name = "status")
	private Integer status;

	public Long getSalerId() {
		return salerId;
	}

	public void setSalerId(Long salerId) {
		this.salerId = salerId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderPostcode() {
		return senderPostcode;
	}

	public void setSenderPostcode(String senderPostcode) {
		this.senderPostcode = senderPostcode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverPostcode() {
		return receiverPostcode;
	}

	public void setReceiverPostcode(String receiverPostcode) {
		this.receiverPostcode = receiverPostcode;
	}
}
