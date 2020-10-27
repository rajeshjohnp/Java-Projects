package com.banking.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.banking.demo.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	@Query("SELECT amount FROM Account WHERE customer_id = :customerId and account_id = :accountId")
	String findAmountByCustomerIdAndAccountId(@Param("customerId") String customerId, @Param("accountId") String accountId);
}
