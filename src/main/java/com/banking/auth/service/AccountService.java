package com.banking.auth.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.banking.auth.entities.AccountDetail;

public interface AccountService {

	@Query("SELECT a FROM AccountDetail a WHERE a.accountNumber=?1")
	AccountDetail fetchAccountDetails(String accountNumber);

	@Modifying
	@Transactional
	@Query("UPDATE AccountDetail a SET a.accountBalance=?1 WHERE a.accountNumber=?2")
	int updateAccountBalance(long accountBalance,String date, String accountNumber);

	int updateAccountBalance(long senderAccountBalance, String date, long accountBalance);

}
