package com.balwant.account.accm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.balwant.account.accm.dao.IUserDAO;
import com.balwant.account.accm.model.User;
import com.balwant.account.accm.service.IUserService;

@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO;
	
	@Override
	public void createUser(User user) {
		this.userDAO.createUser(user);
	}

	@Override
	public User getUser(int userId) {
		return this.userDAO.getUser(userId);
	}

	@Override
	public void deleteUser(int userId) {
		this.userDAO.deleteUser(userId);
	}

	@Override
	public void updateUser(User user) {
		this.userDAO.updateUser(user);
	}

	@Override
	public List<User> getUsers() {
		return this.userDAO.getUsers();
	}

}
