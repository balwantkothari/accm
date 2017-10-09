package com.balwant.account.accm.service;

import java.util.List;

import com.balwant.account.accm.model.Customer;

public interface ICustomerService {

	void createCustomer(Customer customer);

	Customer getCustomer(int custId);

	void updateCustomer(Customer customer);

	void deleteCustomer(int custId);
	
	List<Customer> getAllCustomers();
}
