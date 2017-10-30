package com.balwant.account.accm.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balwant.account.accm.model.Loan;
import com.balwant.account.accm.service.ILoanService;

@RestController
@RequestMapping(value="/loan")
public class LoanController {
	
	static final Logger logger = LogManager.getLogger(LoanController.class);
	
	
	@Autowired
	private ILoanService service;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Void> addLoad(@RequestBody Loan loan) {
		logger.info("Request=AddLoan, loan=" + loan);
		service.createLoan(loan);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public ResponseEntity<Loan> getLoan(@PathVariable("id") int loanId) {
		logger.info("Request=GetLoanByLoanId, loanId=" + loanId );
		return new ResponseEntity<Loan>(service.getLoan(loanId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<Void> updateLoan(@RequestBody Loan loan) {
		logger.info("Request=UpdateLoan, loan=" + loan);
		service.updateLoan(loan);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
