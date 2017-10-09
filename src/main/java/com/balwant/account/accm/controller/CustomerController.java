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

import com.balwant.account.accm.model.Customer;
import com.balwant.account.accm.service.ICustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@RequestMapping(value="/get/{id}" , method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Customer> getCustomerDetail(@PathVariable("id") int custId) {
		return new ResponseEntity<Customer>(service.getCustomer(custId), HttpStatus.OK);
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
		service.createCustomer(customer);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer) {
		service.updateCustomer(customer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value="/get/all" , method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Customer>> getAllCustomerDetails() {
		return new ResponseEntity<List<Customer>>(service.getAllCustomers(), HttpStatus.OK);
	}	
}
