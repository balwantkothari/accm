package com.balwant.account.accm.service;

import java.util.List;

import com.balwant.account.accm.model.Deposit;

public interface IDepositService {
	
	void makeDeposit(Deposit deposit);
	
	Deposit getDeposit(int depositId);
	
	List<Deposit> getDeposits(int loanId);	
}
