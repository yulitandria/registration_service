package com.yulitandria.dao;

import java.util.List;

import com.yulitandria.entity.User;

public interface UserDAO {

	public List<User> getUsers();
	
	public void addUser(User user);
	
	public User getUser(int id);
	
	public User getUserByEmail(String email);
	
	public User getUserByPhoneNumber(String phone);
	
	public void deleteUser(int id);
}
