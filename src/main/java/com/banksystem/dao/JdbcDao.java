package com.banksystem.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.banksystem.model.Contact;
import com.banksystem.model.User;

@Repository
public class JdbcDao implements Dao{

	@Autowired JdbcTemplate jdbc;
	
	@Override
	public User login(String loginId, String loginPass) throws DataAccessException {
		User user = new User();
		try {
			String sql = "SELECT * FROM users_info WHERE loginId = ? AND loginPass = ?";
			Map<String, Object> map = jdbc.queryForMap(sql, loginId, loginPass);
			user.setId((Integer) map.get("id"));
			user.setName((String) map.get("name"));
			user.setPhone((String)map.get("phone"));
			user.setEmail((String)map.get("email"));
			user.setLoginId((String)map.get("loginId"));
			user.setLoginPass((String)map.get("loginPass"));
			user.setAmount((Integer)map.get("amount"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int register(User user) throws DataAccessException {
		int rowNum = -1;
		int errorNum = 9999;
		try {
			String sql = "INSERT INTO users_info(name, phone, email, loginId, loginPass) VALUES(?, ?, ?, ?, ?)";
			rowNum = jdbc.update(sql, user.getName(), user.getPhone(), user.getEmail(), user.getLoginId(), user.getLoginPass());
		}catch(Exception e) {
			e.printStackTrace();
			return errorNum;
		}
		return rowNum;
	}

	@Override
	public int contact(Contact contact) throws DataAccessException {
		int rowNum = -1;
		int errorNum = 9999;
		try {
			String sql = "INSERT INTO contacts(email, message) VALUES(?, ?)";
			rowNum = jdbc.update(sql, contact.getEmail(), contact.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			return errorNum;
		}
		return rowNum;
	}

	@Override
	public int deposit(int id, int sum) throws DataAccessException{
		int rowNum = -1;
		int errorNum = 9999;
		try {
			String sql = "UPDATE users_info SET amount=? WHERE id=?";
			rowNum = jdbc.update(sql, sum, id);
		}catch(DataAccessException e) {
			e.printStackTrace();
			return errorNum;
		}
		return rowNum;
	}

	@Override
	public int withdraw(int id, int sum) throws DataAccessException {
		int rowNum = -1;
		int errorNum = 9999;
		try {
			String sql = "UPDATE users_info SET amount=? WHERE id=?";
			rowNum = jdbc.update(sql, sum, id);
		}catch(DataAccessException e) {
			e.printStackTrace();
			return errorNum;
		}
		return rowNum;
	}

	@Override
	public Integer getAmount(String loginId, String loginPass) throws DataAccessException {
		String sql = "SELECT * FROM users_info WHERE loginId=? AND loginPass=?";
		Map<String, Object> map = jdbc.queryForMap(sql, loginId, loginPass);
		Integer amount = (Integer)map.get("amount");
		return amount;
	}

	@Override
	public int transfer(String phone, String loginId, int amount) throws DataAccessException, EmptyResultDataAccessException{
		int rowNum = -1;
		int errorNum = 9999;
		try {
			String sql = "UPDATE users_info SET amount=? WHERE phone=? AND loginId=?";
			rowNum = jdbc.update(sql, amount, phone, loginId);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return errorNum;
		}
		return rowNum;
	}

	@Override
	public Integer getAmountByPhone(String phone) throws DataAccessException {
		Integer amount = 0;
		try {
			String sql = "SELECT * FROM users_info WHERE phone=?";
			Map<String, Object> map = jdbc.queryForMap(sql, phone);
			amount = (Integer)map.get("amount");
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			amount = -1;
		}
		return amount;
	}

	@Override
	public Integer checkAccount(String phone) throws DataAccessException {
		int id = 0;
		try {
			String sql = "SELECT * FROM users_info WHERE phone=?";
			Map<String, Object> map = jdbc.queryForMap(sql, phone);
			id = (Integer)map.get("id");
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			id = -1;
		}
		return id;
	}

	@Override
	public int changeInfo(String info, int num, int id) throws DataAccessException {
		int numRow = -1;
		String str = null;
		switch(num) {
			case 1: str = "name";
			break;
			case 2: str = "phone";
			break;
			case 3: str = "email";
			break;
			case 4: str = "loginId";
			break;
			case 5: str = "loginPass";
			break;
		}
		try {
			String sql = "UPDATE users_info SET " + str + " =? " + "WHERE id=?";
			numRow = jdbc.update(sql, info, id);
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		return numRow;
	}

}
