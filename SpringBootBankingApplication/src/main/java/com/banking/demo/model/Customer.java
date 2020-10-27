package com.banking.demo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String customerId;

	private String firstName;

	private String lastName;

	private String address;

	private String phoneNo;

	private String ssn;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private List<Account> accounts;
	
	protected Customer() {
	}

	public Customer(String customerId, String fName, String lName, String address, String phoneNo, String ssn) {
		super();
		this.customerId = customerId;
		this.firstName = fName;
		this.lastName = lName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.ssn = ssn;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getSsn() {
		return ssn;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
