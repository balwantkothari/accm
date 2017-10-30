package com.balwant.account.accm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.balwant.account.accm.dao.ICustomerDAO;
import com.balwant.account.accm.dao.ILoanDAO;
import com.balwant.account.accm.model.Customer;
import com.balwant.account.accm.model.Loan;
import com.balwant.account.accm.service.ICustomerService;

@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	private ILoanDAO loanDAO;

	@Override
	public void createCustomer(Customer customer) {
		this.customerDAO.createCustomer(customer);
		if(customer.getLoans() != null) {
			for(Loan loan : customer.getLoans()) {
				this.loanDAO.createLoan(loan);							
			}
		}
	}

	@Override
	public Customer getCustomerById(int custId) {
		return this.customerDAO.getCustomerById(custId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		this.customerDAO.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(int custId) {
		this.deleteCustomer(custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.customerDAO.getAllCustomers();
	}

	@Override
	public List<Customer> getCustomerByName(String custName) {
		return this.customerDAO.getCustomerByName(custName);
	}

}
