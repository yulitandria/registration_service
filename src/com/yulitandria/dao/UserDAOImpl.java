package com.yulitandria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yulitandria.entity.User;


@Repository
public class UserDAOImpl implements UserDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<User> theQuery = currentSession.createQuery("from user", User.class);

		// execute query and get result list
		List<User> listysers= theQuery.getResultList();

		// return the results
		return listysers;
	}

	@Override
	public void addUser(User user) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save to database
		currentSession.saveOrUpdate(user);

	}

	@Override
	public User getUser(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		User tempStaff = currentSession.get(User.class, id);
		return tempStaff;
	}

	

	@Override
	public void deleteUser(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, id);
		currentSession.delete(user);

	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		User tempStaff = currentSession.get(User.class, email);
		return tempStaff;
	}

	@Override
	public User getUserByPhoneNumber(String phone) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		User tempStaff = currentSession.get(User.class, phone);
		return tempStaff;
	}

}
