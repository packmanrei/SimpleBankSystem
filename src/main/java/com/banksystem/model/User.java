package com.banksystem.model;

import java.io.Serializable;

public class User implements Serializable {
	private Integer id ;
	private String name;
	private String loginId;
	private String loginPass;
	private String phone;
	private String email;
	
	private Integer amount;
	
	//getter
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLoginId() {
		return loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public Integer getAmount() {
		return amount;
	}
	
	//setter
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
