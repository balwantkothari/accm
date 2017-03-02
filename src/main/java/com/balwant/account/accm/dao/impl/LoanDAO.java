package com.balwant.account.accm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.balwant.account.accm.dao.ILoanDAO;
import com.balwant.account.accm.model.Loan;

@Repository
public class LoanDAO implements ILoanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createLoan(Loan loan) {
		Session session = sessionFactory.getCurrentSession();
		session.save(loan);
	}

	@Override
	public Loan getLoan(int loanId) {
		Session session = sessionFactory.getCurrentSession();
		return (Loan) session.get(Loan.class, loanId);
	}

	@Override
	public void updateLoan(Loan loan) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(loan);
	}

	@Override
	public void deleteLoan(Loan loan) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(loan);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getLoans() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM LOAN").list();

	}

}
