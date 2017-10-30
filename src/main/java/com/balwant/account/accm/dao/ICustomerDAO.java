package com.balwant.account.accm.dao;

import java.util.List;

import com.balwant.account.accm.model.Customer;

public interface ICustomerDAO {

	void createCustomer(Customer customer);

	Customer getCustomerById(int custId);

	List<Customer> getCustomerByName(String custName);

	void updateCustomer(Customer customer);
	
	List<Customer> getAllCustomers();
}
