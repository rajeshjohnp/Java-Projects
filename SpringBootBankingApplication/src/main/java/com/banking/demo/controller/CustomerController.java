package com.banking.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.model.Customer;
import com.banking.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getCustomers();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/transferAcct1ToAcct2")
	public Customer tfrAcc1ToAcc2(@RequestParam("id") String id, 
								  @RequestParam("srcAcctId") String srcAcctId, 
								  @RequestParam("tgtAcctId") String tgtAcctId, 
								  @RequestParam("trnfrAmount") String trnfrAmount) {
		Customer customer = customerService.tfrAcc1ToAcc2(id, srcAcctId, tgtAcctId, trnfrAmount);
		return customer;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/customers/{id}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
		customerService.updateCustomer(id, customer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/customers/{id}")
	public void deleteCustomer(@PathVariable String id) {
		customerService.deleteCustomer(id);
	}

}
