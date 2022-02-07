package com.banking.auth.util;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AccountNumerGenerator {

	public String generateTransactionPin;
	public int generateAccountnumber()
	{
		 Random random= new Random();
		 int accountNumber=100000 + random.nextInt(999999);
		return accountNumber;
	}
	public int generateTransactionPin()
	{
		 Random random= new Random();
		 int transactionPin=100000 + random.nextInt(999999);
		return transactionPin;
	}

}
