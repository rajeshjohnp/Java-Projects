package com.banking.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.banking.demo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
