package com.balwant.account.accm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.balwant.account.accm.dao.IDepositDAO;
import com.balwant.account.accm.model.Deposit;

@Repository
public class DepositDAO implements IDepositDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void makeDeposit(Deposit deposit) {
		Session session = sessionFactory.getCurrentSession();
		session.save(deposit);
	}

	@Override
	public Deposit getDeposit(int depositId) {
		Session session = sessionFactory.getCurrentSession();
		return (Deposit) session.get(Deposit.class, depositId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deposit> getDeposits(int loanId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM DEPOSIT").list();
	}

}
