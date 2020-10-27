package com.banking.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.demo.model.Account;
import com.banking.demo.model.Customer;
import com.banking.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Autowired
	public AccountService accountService;
	
	List<Customer> customerList = new ArrayList<Customer>();
	
//	List<Customer> CustomerList = new ArrayList<Customer>(Arrays.asList(
//			new Customer("10001", "Rajesh", "Administrator"),
//			new Customer("10002", "John", "DBA"),
//			new Customer("10003", "Jacob", "Analyst")));
	
	public List<Customer> getCustomers() {
		List<Customer> CustomerList = new ArrayList();
		customerRepository.findAll()
			.forEach(customerList::add);
//		customerList = new ArrayList<Customer>(Arrays.asList(
//				new Customer("10001", "Rajesh", "Puthukunnathu", "Teel Pkwy", "9001102001", "1010100"),
//				new Customer("10002", "John", "Rajesh", "Lebanon Rd", "9001102002", "1010101"),
//				new Customer("10003", "Jacob", "Xavier", "Main St", "9001102003", "1010102")));

		
		return customerList;
	}
	
	public Customer getCustomer(String id) {
		return customerList.stream().filter(t -> t.getCustomerId().equals(id)).findFirst().get();
	}
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);	
	}
		
	public void updateCustomer(String id, Customer customer) {
		for (int i = 0; i < customerList.size(); i++) {
			Customer cust = customerList.get(i);
			if (cust.getCustomerId().equals(id)) {
				customerList.set(i, customer);
				return;
			}
		}
	}
		
	public void deleteCustomer(String id) {
		customerList.removeIf(customer -> customer.getCustomerId().equals(id));	
	}
	
	public Customer tfrAcc1ToAcc2(String id, String sourceAccountId, String targetAccountId, String transferAmount) {
		Long sourceAccountAmount = Long.valueOf(accountService.getAccountAmount(id, sourceAccountId));
		Long targetAccountAmount = Long.valueOf(accountService.getAccountAmount(id, targetAccountId));
		Long newSourceAmount = sourceAccountAmount - Long.valueOf(transferAmount);
		Long newTargetAmount = targetAccountAmount + Long.valueOf(transferAmount);
		Customer customer = null;
		for (int i = 0; i < customerList.size(); i++) {
			Customer cust = customerList.get(i);
			if (cust.getCustomerId().equals(id)) {
				for (Account account : cust.getAccounts()) {
					if (account.getAccountId().equals(sourceAccountId)) {
						account.setAmount(String.valueOf(newSourceAmount));
					}
					if (account.getAccountId().equals(targetAccountId)) {
						account.setAmount(String.valueOf(newTargetAmount));
					}
				}
				cust.setAccounts(cust.getAccounts());
				customerList.set(i, cust);
				customer = cust;
				break;
			}
		}
		return customer;
	}

}
