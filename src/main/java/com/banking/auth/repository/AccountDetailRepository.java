package com.banking.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banking.auth.entities.AccountDetail;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail, Long> {

	@Query("SELECT a FROM AccountDetail a WHERE a.accountNumber=?1")
	AccountDetail fetchAccountDetails(String accountNumber);

	@Modifying
	@Transactional
	@Query("UPDATE AccountDetail a SET a.accountBalance= ?1, a.updatedAt=?2 WHERE a. accountNumber=?3")
	int updateAccountBalance(long accountBalance,String date, String accountNumber);

}
