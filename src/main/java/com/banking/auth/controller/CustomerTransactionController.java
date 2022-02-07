package com.banking.auth.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.auth.CustomerRequest.CustomerRequestForMoneyTransfer;
import com.banking.auth.controller.customerespose.customerResponseForNoUser;
import com.banking.auth.entities.AccountDetail;
import com.banking.auth.entities.CustomerTransaction;
import com.banking.auth.entities.customers;
import com.banking.auth.service.AccountService;
import com.banking.auth.service.CustomerService;
import com.banking.auth.service.CustomerTransactionService;
import com.banking.auth.util.validations;

@RestController
@RequestMapping("customer/transaction")
public class CustomerTransactionController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerTransactionService customerTransactionService;
	
	@Autowired
	validations validation;
	
	@Autowired
	CustomerService customerService;
	
	DateFormat dateFormat= new SimpleDateFormat("dd-mm--yyyy HH:mm:ss");
	
	
	@PostMapping("addBalance")
	public ResponseEntity<Object>addBalance(@RequestBody AccountDetail accountDetail )
	{
		validation.addBalanaceValidations(accountDetail);
		
		AccountDetail fetchedAccountDetail = accountService.fetchAccountDetails(accountDetail.getAccountNumber());
		if(fetchedAccountDetail != null)
		{
			long accountBalance =fetchedAccountDetail.getAccountBalance()+ accountDetail.getAccountBalance();
			
			String date=""+dateFormat.format(new Date());
			
			accountService.updateAccountBalance(accountBalance,date,accountDetail.getAccountNumber());
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Account Balance Updated Successful..","200");
			return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
		}
		else
		{
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Invalid Account Number..","409");
			return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
		}
		
	}
	@PostMapping("transferMoney")
	public ResponseEntity<Object>transferMoney(@RequestBody CustomerRequestForMoneyTransfer moneyTransfer )
	{
		
		AccountDetail fetchedAccountDetail = accountService.fetchAccountDetails(moneyTransfer.getAccountNumber());
		if(fetchedAccountDetail !=null)
		{
			AccountDetail fetchReceiverAccountDetail = accountService.fetchAccountDetails(moneyTransfer.getUserAccountNumber());
			if(fetchReceiverAccountDetail != null)
			{
				long senderAccountBalance = fetchedAccountDetail.getAccountBalance()- moneyTransfer.gettransferAmount();
				
				String date=""+dateFormat.format(new Date());
				
				accountService.updateAccountBalance(senderAccountBalance, date,fetchedAccountDetail.getAccountNumber());
				
				CustomerTransaction sendersTransactionLog= new CustomerTransaction();
				sendersTransactionLog.setAccountNumber(moneyTransfer.getAccountNumber());
				sendersTransactionLog.setTransferAmount(moneyTransfer.gettransferAmount());
				sendersTransactionLog.setUserAccountNumber(fetchReceiverAccountDetail.getAccountNumber());
				sendersTransactionLog.setBranchName(fetchReceiverAccountDetail.getBranchName());
				sendersTransactionLog.setIfsc(fetchReceiverAccountDetail.getIfsc());
				sendersTransactionLog.setStatus("Debit");
				sendersTransactionLog.setCreatedAt(date);
				sendersTransactionLog.setUpdatedAt(date);

				customerTransactionService.saveTransactionLog(sendersTransactionLog);
				
	
				long receiverAccountBalance = fetchReceiverAccountDetail.getAccountBalance()+ moneyTransfer.gettransferAmount();
				accountService.updateAccountBalance(receiverAccountBalance, date,fetchReceiverAccountDetail.getAccountNumber());
				
				CustomerTransaction receiversTransactionLog= new CustomerTransaction();
				receiversTransactionLog.setAccountNumber(fetchReceiverAccountDetail.getAccountNumber());
				receiversTransactionLog.setTransferAmount(moneyTransfer.gettransferAmount());
				receiversTransactionLog.setUserAccountNumber(moneyTransfer.getAccountNumber());
				receiversTransactionLog.setBranchName(moneyTransfer.getBranchName());
				receiversTransactionLog.setIfsc(moneyTransfer.getIfsc());
				receiversTransactionLog.setStatus("Credit");
				receiversTransactionLog.setCreatedAt(date);
				receiversTransactionLog.setUpdatedAt(date);
				
				customerTransactionService.saveTransactionLog(receiversTransactionLog);

				customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
						"Money transfer Successfully..","200");
				return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
			}
			else
			{
				customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
						"Receiver Account Not Found..","409");
				return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
			}
			
		}
		else
		{
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Senders Account Not Found","409");
			return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
		}
		
		
	}
	@PostMapping("/updateCustomer")
	public ResponseEntity<Object>updateCustomer(@RequestBody customers customer )
	{
		customers customerUpdate=customerService.findById(customer.getCustomerId());
		if(customerUpdate !=null)
		{
			customerService.updateCustomer(customer.getFirstName(),customer.getMiddleName(),
			customer.getLastName(),customer.getAddress(),customer.getCustomerId());
			
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Customer Updated Successfully..","200");
			return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
		}
		else
		{
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Customer Not Found","409");
			return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
		}
		
	}

}
