package com.yulitandria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yulitandria.entity.User;


@Service
public class UserServiceImpl implements UserService{

	// need to inject UserDAO
	@Autowired
	private com.yulitandria.dao.UserDAO UserDAO;
	
	@Override
	@Transactional
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return UserDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User User) {
		UserDAO.addUser(User);
		
	}

	@Override
	@Transactional
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return UserDAO.getUser(id);
	}


	@Override
	@Transactional
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		UserDAO.deleteUser(id);
		
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return UserDAO.getUserByEmail(email);
	}

	@Override
	@Transactional
	public User getUserByPhoneNumber(String phone) {
		// TODO Auto-generated method stub
		return UserDAO.getUserByPhoneNumber(phone);
	}

}
