package com.balwant.account.accm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.balwant.account.accm.dao.IUserDAO;
import com.balwant.account.accm.model.User;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public User getUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, userId);
	}

	@Override
	public void deleteUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, userId);
		session.delete(user);
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM USER").list();
	}

}
