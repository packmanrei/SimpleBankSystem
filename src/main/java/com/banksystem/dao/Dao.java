package com.banksystem.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.banksystem.model.Contact;
import com.banksystem.model.User;

@Repository
public interface Dao {
	//login method
	public User login(String loginId, String loginPass) throws DataAccessException;
	
	//register method
	public int register(User user) throws DataAccessException;
	
	//contact method
	public int contact(Contact contact) throws DataAccessException;
	
	//deposit method
	public int deposit(int id, int sum) throws DataAccessException;
	
	//withdraw method
	public int withdraw(int id, int sum) throws DataAccessException;
	
	//get amount by id and password
	public Integer getAmount(String loginId, String loginPass) throws DataAccessException;
	
	//transfer method
	public int transfer(String phone, String loginId, int Amount) throws DataAccessException;
	
	//get amount by phonenumber
	public Integer getAmountByPhone(String phone) throws DataAccessException;
	
	//check account by phone
	public Integer checkAccount(String phone) throws DataAccessException;
	
	//change info
	public int changeInfo(String info, int num, int id) throws DataAccessException;
}
