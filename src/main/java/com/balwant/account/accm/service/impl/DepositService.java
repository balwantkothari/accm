package com.balwant.account.accm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.balwant.account.accm.dao.IDepositDAO;
import com.balwant.account.accm.model.Deposit;
import com.balwant.account.accm.service.IDepositService;

@Transactional
public class DepositService implements IDepositService {

	@Autowired
	IDepositDAO depositDAO;
	
	@Override
	public void makeDeposit(Deposit deposit) {
		this.depositDAO.makeDeposit(deposit);
	}

	@Override
	public Deposit getDeposit(int depositId) {
		return this.depositDAO.getDeposit(depositId);
	}

	@Override
	public List<Deposit> getDeposits(int loanId) {
		return this.depositDAO.getDeposits(loanId);
	}

}
