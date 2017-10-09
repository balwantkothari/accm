package com.balwant.account.accm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balwant.account.accm.model.Deposit;
import com.balwant.account.accm.service.IDepositService;

@RestController
@RequestMapping(value = "/deposit")
public class DepositController {

	@Autowired
	IDepositService service;

	@RequestMapping(value = "/add" , method=RequestMethod.POST)
	public ResponseEntity<Void> makeDeposit(@RequestBody Deposit deposit) {
		service.makeDeposit(deposit);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/get/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Deposit>> getDepsits(@PathVariable("id") int loanId) {
		return new ResponseEntity<List<Deposit>>(service.getDeposits(loanId), HttpStatus.OK);
	}

	@RequestMapping(value = "/get/{id}/{depositId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Deposit> getDesposit(@PathVariable("depositId") int depositId) {
		return new ResponseEntity<Deposit>(service.getDeposit(depositId), HttpStatus.OK);
	}

}
