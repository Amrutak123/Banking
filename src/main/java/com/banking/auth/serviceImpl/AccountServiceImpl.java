package com.banking.auth.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.AccountDetail;
import com.banking.auth.repository.AccountDetailRepository;
import com.banking.auth.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDetailRepository accountDetailRepository;
	
	
	
	@Override
	public AccountDetail fetchAccountDetails(String accoutNumber) {
		return accountDetailRepository.fetchAccountDetails(accoutNumber);
	}



	@Override
	public int updateAccountBalance( long accountBalance,String date,String accountNumber) {
		// TODO Auto-generated method stub
		return accountDetailRepository.updateAccountBalance(accountBalance,date,accountNumber);
	}



	@Override
	public int updateAccountBalance(long senderAccountBalance, String date, long accountBalance) {
		// TODO Auto-generated method stub
		return 0;
	}

}
