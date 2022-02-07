package com.banking.auth.util;

import org.springframework.stereotype.Service;

import com.banking.auth.CustomerRequest.UpdatePassword;
import com.banking.auth.entities.AccountDetail;
import com.banking.auth.entities.customers;
import com.banking.auth.exception.InvalidRequestException;

@Service
public class validations {

	public static void registerCustomer(customers customer) {
		if(customer.getFirstName().equals(""))
		{
			throw new InvalidRequestException("First Name should not be null:");
		}
		String emailRegex ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(customer.getEmail().matches(emailRegex)==false)
		{
			throw new InvalidRequestException("Email id should be in proper format:");
		}
	}

	public static void loginCustomer(customers customer) {
		String emailRegex ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(customer.getEmail().matches(emailRegex)==false)
		{
			throw new InvalidRequestException("Email id should be in proper format:");
		}
		if(customer.getEmail().equals(""))
		{
			throw new InvalidRequestException("Email id should not be empty");
		}
		if(customer.getPassword().equals(""))
		{
			throw new InvalidRequestException("Password should not be empty");
		}
	}

	public void addBalanaceValidations(AccountDetail accountDetail) {
		
		if(accountDetail.getAccountNumber().equals(""))
		{
			throw new InvalidRequestException("Account Number should not be empty");
		}
		if(accountDetail.getAccountBalance()<=0)
		{
			throw new InvalidRequestException("Account Number should not be zero or negative.");
		}
	}

	public static void updatePassword(UpdatePassword updatePassword) {
		
		String emailRegex ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(updatePassword.getEmail().matches(emailRegex)==false)
		{
			throw new InvalidRequestException("Email id should be in proper format:");
		}
		
		if(updatePassword.getNewPassword().equals(""))
		{
			throw new InvalidRequestException("New Password should not be null:");
		}
		if(updatePassword.getConfirmPassword().equals(""))
		{
			throw new InvalidRequestException("Confirm Password should not be null:");
		}
	}

	
	}

