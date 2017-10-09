package com.balwant.account.accm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.balwant.account.accm.dao.ILoanDAO;
import com.balwant.account.accm.model.Loan;
import com.balwant.account.accm.service.ILoanService;
import com.balwant.account.accm.util.InterestCalculator;

@Transactional
public class LoanService implements ILoanService {

	@Autowired
	private ILoanDAO loanDAO;
	
	@Autowired
	private InterestCalculator interestCaculator;
	
	@Override
	public void createLoan(Loan loan) {
		this.loanDAO.createLoan(loan);
	}

	@Override
	public Loan getLoan(int loanId) {
		Loan loan = this.loanDAO.getLoan(loanId);
		loan.setAmountDetails(this.interestCaculator.getFinalAmount(loan));
		return loan;
	}

	@Override
	public void updateLoan(Loan loan) {
		this.loanDAO.updateLoan(loan);
	}

	@Override
	public void deleteLoan(int loanId) {
		this.deleteLoan(loanId);
	}

	@Override
	public List<Loan> getLoans() {
		return this.loanDAO.getLoans();
	}
}
