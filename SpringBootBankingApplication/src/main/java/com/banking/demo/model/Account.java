package com.banking.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Account")
@NoArgsConstructor
@AllArgsConstructor

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String accountId;

	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "customerId")
    @JsonIgnore
	private Customer customer;
	
	private String accountType;

	private String amount;

	public Account() {
	}

	public Account(String accType, String dollarAmount) {
		super();
		this.accountType = accType;
		this.amount = dollarAmount;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAmount() {
		return amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
