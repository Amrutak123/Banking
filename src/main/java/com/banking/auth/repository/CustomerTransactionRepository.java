package com.banking.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.auth.entities.CustomerTransaction;

@Repository
public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long>
{

	//CustomerTransaction saveTransactionLog(CustomerTransaction sendersTransactionLog);
	//CustomerTransaction saveTransactionLog(CustomerTransaction sendersTransactionLog);


}
