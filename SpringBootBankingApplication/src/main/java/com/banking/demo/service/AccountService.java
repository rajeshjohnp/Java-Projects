package com.banking.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.demo.model.Account;
import com.banking.demo.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	public AccountRepository accountRepository;
	
	List<Account> accountList = new ArrayList<Account>();
	
//	List<Account> accountList = new ArrayList<Account>(Arrays.asList(
//			new Account("10001", "Rajesh", "Administrator"),
//			new Account("10002", "John", "DBA"),
//			new Account("10003", "Jacob", "Analyst")));
	
	public List<Account> getAccounts() {
		List<Account> accountList = new ArrayList();
		accountRepository.findAll()
			.forEach(accountList::add);
//		customerList = new ArrayList<Customer>(Arrays.asList(
//				new Customer("10001", "Rajesh", "Puthukunnathu", "Teel Pkwy", "9001102001", "1010100"),
//				new Customer("10002", "John", "Rajesh", "Lebanon Rd", "9001102002", "1010101"),
//				new Customer("10003", "Jacob", "Xavier", "Main St", "9001102003", "1010102")));

		
		return accountList;
	}
	
	public Account getAccount(String id) {
		return accountList.stream().filter(t -> t.getAccountId().equals(id)).findFirst().get();
	}
	
	public void addAccount(Account account) {
		accountRepository.save(account);	
	}
		
	public void updateAccount(String id, Account account) {
		for (int i = 0; i < accountList.size(); i++) {
			Account c = accountList.get(i);
			if (c.getAccountId().equals(id)) {
				accountList.set(i, account);
				return;
			}
		}
	}
		
	public void deleteAccount(String id) {
		accountList.removeIf(t -> t.getAccountId().equals(id));	
	}
	
	public String getAccountAmount (String customerId, String accountId) {
		String amount = accountRepository.findAmountByCustomerIdAndAccountId(customerId, accountId);
		return amount;
	}

}
