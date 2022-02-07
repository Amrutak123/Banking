package com.banking.auth.serviceImpl;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.AccountDetail;
import com.banking.auth.entities.PasswordResetTokenEntity;
import com.banking.auth.entities.customers;
import com.banking.auth.repository.AccountDetailRepository;
import com.banking.auth.repository.CustomerRepository;
import com.banking.auth.repository.PasswordResetRepository;
import com.banking.auth.service.CustomerService;
import com.banking.auth.util.AccountNumerGenerator;
import com.banking.auth.util.MailService;




@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountDetailRepository accountDetailRepository;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	AccountNumerGenerator accountNumerGenerator;
	PasswordEncoder passwordEncoder;
	
	DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
	
	@Override
	public customers registerCustomer(customers customer) {
		
		this.passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = this. passwordEncoder.encode(customer.getPassword());
		customer.setPassword(encodedPassword);
		String currentTime = dateFormat.format(new Date());
		String accountNumber = accountNumerGenerator.generateAccountnumber()+""+ accountNumerGenerator.generateAccountnumber();
		customer.setAccountNumber(accountNumber);
		customer.setTransactionPin(""+ accountNumerGenerator.generateAccountnumber() );
		customer.setStatus("1");
		customer.setCreatedAt(currentTime);
		customer.setUpdatedAt(currentTime);
		
		return customerRepository.save(customer);
	}

	@Override
	public customers findCustomerByEmail(String email) {
		return customerRepository.findCustomerByEmail(email);
	}
	
	@Override
	public AccountDetail addAccountDetail(AccountDetail accountDetail) {
		return accountDetailRepository.save(accountDetail);
	}

	@Override
	public customers findById(long customerId) {
		return customerRepository.findById(customerId);
	}

	@Override
	public int updateCustomer(String firstName, String middleName, String lastName, String address,long customerId) {
		return customerRepository.updateCustomer(firstName, middleName, lastName, address,customerId);
	}
	@Override
	public int updatePassword(String confirmPassword, String email) {
		return customerRepository.updatePassword(confirmPassword,email);
	}

	@Override
	public boolean requestPasswordReset(String email) {
		boolean returnValue= false;
		customers customer = customerRepository.findCustomerByEmail(email);
		
		if(customer ==null)
		{
			return returnValue;
		}
		String token =Utils.generatePasswordResetToken(customer.getCustomerId());
		PasswordResetTokenEntity passwordResetTokenEntity =new PasswordResetTokenEntity();
		passwordResetTokenEntity.setToken(token);
		passwordResetTokenEntity.setCustomer(customer);
		PasswordResetRepository.save(passwordResetTokenEntity);
		
		returnValue=mailService.sendPasswordResetRequest(customer.getFirstName(),customer.getEmail(),token);
		return returnValue;
	}


	}
