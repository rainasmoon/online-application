package com.rainasmoon.onepay.vo;

import javax.validation.constraints.Size;

public class FillOrderVo {

	@Size(max = 100, message = "{error.too.lang}")
	private String senderName;
	@Size(max = 100, message = "{error.too.lang}")
	private String senderPhone;
	@Size(max = 100, message = "{error.too.lang}")
	private String senderAddress;
	@Size(max = 100, message = "{error.too.lang}")
	private String senderPostcode;
	@Size(max = 100, message = "{error.too.lang}")
	private String receiverName;
	@Size(max = 100, message = "{error.too.lang}")
	private String receiverPhone;
	@Size(max = 100, message = "{error.too.lang}")
	private String receiverAddress;
	@Size(max = 100, message = "{error.too.lang}")
	private String receiverPostcode;

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
