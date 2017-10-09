package com.balwant.account.accm.service;

import java.util.List;

import com.balwant.account.accm.model.Loan;

public interface ILoanService {

	void createLoan(Loan loan);
	
	Loan getLoan(int loanId);
	
	void updateLoan(Loan loan);
	
	void deleteLoan(int loanId);

	List<Loan> getLoans();
}
