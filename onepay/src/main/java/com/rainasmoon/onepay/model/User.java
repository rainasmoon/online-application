package com.rainasmoon.onepay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@Column(name = "password")
	private String password;
	@Column(name = "nick_name")
	private String nickName;
	@Column(name = "sell_amount")
	private Integer sellAmount;
	@Column(name = "buy_amount")
	private Integer buyAmount;
	@Column(name = "total_amount")
	private Integer totalAmount;
	@Column(name = "account")
	private Integer account;
	@Column(name = "level")
	private Integer level;
	@Column(name = "credit")
	private Integer credit;

	public String getShowName() {
		if (StringUtils.isNotBlank(nickName)) {
			return nickName;
		}
		if (StringUtils.isNotBlank(phone)) {
			return phone;
		}
		if (StringUtils.isNotBlank(email)) {
			return email;
		}
		return id.toString();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSellAmount() {
		return sellAmount;
	}

	public void setSellAmount(Integer sellAmount) {
		this.sellAmount = sellAmount;
	}

	public Integer getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(Integer buyAmount) {
		this.buyAmount = buyAmount;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

}
