package com.balwant.account.accm.dao;

import java.util.List;

import com.balwant.account.accm.model.Deposit;

public interface IDepositDAO {
	
	void makeDeposit(Deposit deposit);
	
	Deposit getDeposit(int depositId);
	
	List<Deposit> getDeposits(int loanId);	
}
