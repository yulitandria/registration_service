package com.yulitandria.service;

import java.util.List;

import com.yulitandria.entity.User;

public interface UserService {

	public List<User> listUser();
	
	public void saveUser(User User);
	
	public User getUser(int id);
	
	public User getUserByEmail(String email);
	
	public User getUserByPhoneNumber(String phone);
	
	public void deleteUser(int id); 
}
