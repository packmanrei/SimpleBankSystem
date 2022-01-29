package com.banksystem.model;

import java.io.Serializable;

public class Contact implements Serializable {
	private String email;
	private String message;
	
	public String getEmail() {
		return email;
	}
	public String getMessage() {
		return message;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
