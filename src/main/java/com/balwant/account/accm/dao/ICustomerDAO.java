package com.balwant.account.accm.dao;

import java.util.List;

import com.balwant.account.accm.model.Customer;

public interface ICustomerDAO {

	void createCustomer(Customer customer);

	Customer getCustomer(int custId);

	void updateCustomer(Customer customer);
	
	List<Customer> getAllCustomers();
}
