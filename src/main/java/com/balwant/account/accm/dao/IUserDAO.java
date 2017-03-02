package com.balwant.account.accm.dao;

import java.util.List;

import com.balwant.account.accm.model.User;

public interface IUserDAO {

	void createUser(User user);
	
	User getUser(int userId);
	
	void deleteUser(int userId);
	
	void updateUser(User user);
	
	List<User> getUsers();
}
