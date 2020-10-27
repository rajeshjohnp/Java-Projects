package com.banking.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.model.Account;
import com.banking.demo.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAccounts();
	}
	
	@RequestMapping("/accounts/{id}")
	public Account getAccount(@PathVariable String id) {
		return accountService.getAccount(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/accounts")
	public void addAccount(@RequestBody Account account) {
		accountService.addAccount(account);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/accounts/{id}")
	public void updateAccount(@RequestBody Account account, @PathVariable String id) {
		accountService.updateAccount(id, account);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/accounts/{id}")
	public void deleteAccount(@PathVariable String id) {
		accountService.deleteAccount(id);
	}

}
