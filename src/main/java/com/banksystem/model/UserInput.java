package com.banksystem.model;

import java.io.Serializable;

public class UserInput implements Serializable {
	private String name;
	private String phone;
	private String email;
	private String loginId;
	private String loginPass;
	private String inputNum;
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getLoginId() {
		return loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public String getInputNum() {
		return inputNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public void setInputNum(String inputNum) {
		this.inputNum = inputNum;
	}
}
