package com.banking.auth.service;

import com.banking.auth.entities.AccountDetail;
import com.banking.auth.entities.customers;

public interface CustomerService {

	customers registerCustomer(customers customer);

	customers findCustomerByEmail(String email);

	AccountDetail addAccountDetail(AccountDetail accountDetail);

	customers findById(long customerId);

	int updateCustomer(String firstName, String middleName, String lastName, String address, long customerId);
	
	int updatePassword(String confirmPassword, String email);

   boolean requestPasswordReset(String email);

	


}
