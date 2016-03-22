package com.rainasmoon.onepay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accountlogs")
public class AccountLog extends BaseEntity {

	@Column(name = "user_id")
	private Long userId;
	@Column(name = "changeAmount")
	private Integer changeAmount;
	@Column(name = "balance")
	private Integer balance;
	@Column(name = "type")
	private Integer type;
	@Column(name = "description")
	private String description;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getChangeAmount() {
		return changeAmount;
	}

	public void setChangeAmount(Integer changeAmount) {
		this.changeAmount = changeAmount;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
