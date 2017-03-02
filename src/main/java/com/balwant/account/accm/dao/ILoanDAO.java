package com.balwant.account.accm.dao;

import java.util.List;

import com.balwant.account.accm.model.Loan;

public interface ILoanDAO {

	void createLoan(Loan loan);
	
	Loan getLoan(int loanId);
	
	void updateLoan(Loan loan);
	
	void deleteLoan(Loan loan);

	List<Loan> getLoans();
}
