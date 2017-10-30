package com.balwant.account.accm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.balwant.account.accm.dao.ICustomerDAO;
import com.balwant.account.accm.model.Customer;

@Repository
public class CustomerDAO implements ICustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
	}

	@Override
	public Customer getCustomerById(int custId) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class, custId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerByName(String custName) {
		Session session = this.sessionFactory.getCurrentSession();
		return (List<Customer>) session.get(Customer.class, custName);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM CUSTOMER").list();
	}

}
