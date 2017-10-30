package com.balwant.account.accm.service;

import java.util.List;

import com.balwant.account.accm.model.Customer;

public interface ICustomerService {

	void createCustomer(Customer customer);

	Customer getCustomerById(int custId);
	
	List<Customer> getCustomerByName(String custName);

	void updateCustomer(Customer customer);

	void deleteCustomer(int custId);
	
	List<Customer> getAllCustomers();
}
