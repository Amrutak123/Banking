package com.banking.auth.service;

import com.banking.auth.entities.CustomerTransaction;

public interface CustomerTransactionService {
	CustomerTransaction saveTransactionLog(CustomerTransaction sendersTransactionLog);


}