package com.banksystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.banksystem.dao.Dao;
import com.banksystem.model.Contact;
import com.banksystem.model.User;

@Service
public class BSService {
	
	@Autowired
	Dao dao;
	
	//login
	public User login(String loginId, String loginPass) {
		User user = dao.login(loginId, loginPass);
		return user;
	}
	
	//register
	public int register(User user) {
		int rowNum = dao.register(user);
		return rowNum;
	}
	
	//contact
	public int contact(Contact contact) {
		int rowNum = dao.contact(contact);
		return rowNum;
	}
	
	//deposit
	public int deposit(int id, int sum) {
		int rowNum = dao.deposit(sum,  id);
		return rowNum;
	}
	
	//withdraw
	public int withdraw(int id, int sum) {
		int rowNum = dao.deposit(id, sum);
		return rowNum;
	}
	
	//getAmount
	public Integer getAmount(String loginId, String loginPass) {
		Integer amount = dao.getAmount(loginId,  loginPass);
		return amount;
	}
	
	//transfer
	public int transfer(String phone, String loginId, int amount) throws EmptyResultDataAccessException{
		int numRow = dao.transfer(phone, loginId, amount);
		return numRow;
	}
	
	//getAMountByPhone
	public Integer getAmountByPhone(String phone) {
		Integer amount = dao.getAmountByPhone(phone);
		return amount;
	}
	
	//checkAccount
	public Integer checkAccount(String phone) {
		Integer id = dao.checkAccount(phone);
		return id;
	}
	
	//changeInfo
	public int changeInfo(String info, int num, int id) {
		int numRow = dao.changeInfo(info, num, id);
		return numRow;
	}
}
