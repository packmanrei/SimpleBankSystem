package com.banksystem.model;

import java.io.Serializable;

public class Transfer implements Serializable {
	private String phone;
	private String loginId;
	private String amount;
	
	public String getPhone() {
		return phone;
	}
	public String getLoginId() {
		return loginId;
	}
	public String getAmount() {
		return amount;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
