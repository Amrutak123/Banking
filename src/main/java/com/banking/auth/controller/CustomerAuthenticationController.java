package com.banking.auth.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.auth.controller.customerespose.CustomerResponseForAccountDetail;
import com.banking.auth.controller.customerespose.CustomerResponseForCustomerRegister;
import com.banking.auth.controller.customerespose.OperationStatus;
import com.banking.auth.controller.customerespose.RequestOperationStatus;
import com.banking.auth.controller.customerespose.customerResponseForNoUser;
import com.banking.auth.entities.AccountDetail;
import com.banking.auth.entities.PasswordResetTokenEntity;
import com.banking.auth.entities.customers;
import com.banking.auth.service.AccountService;
import com.banking.auth.service.CustomerService;
import com.banking.auth.util.AccountNumerGenerator;
import com.banking.auth.util.MailService;
import com.banking.auth.util.validations;
import com.banking.auth.CustomerRequest.CustomOtpRequest;
import com.banking.auth.CustomerRequest.PasswordResetRequestModel;
//import com.banking.auth.CustomerRequest.CustomOtpRequest;
import com.banking.auth.CustomerRequest.UpdatePassword;

@RestController
@CrossOrigin
@RequestMapping("/customer/auth")
public class CustomerAuthenticationController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	validations validation;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	AccountNumerGenerator accountNumerGenerator;

	@PostMapping("/registerCustomer")
	public ResponseEntity<Object> registerCustomer(@RequestBody customers customer)
	{
		validations.registerCustomer(customer);
		customers findCustomer = customerService.findCustomerByEmail(customer.getEmail());
		if(findCustomer == null)
		{
			customers registerdCustomer = customerService.registerCustomer(customer);
			AccountDetail accountDetail = new AccountDetail();
			accountDetail.setAccountNumber(registerdCustomer.getAccountNumber());
			accountDetail.setBranchName("pune");
			accountDetail.setCustomerId(registerdCustomer);
			accountDetail.setAccountBalance(0);
			accountDetail.setIfsc("PARK202122");
			accountDetail.setStatus(registerdCustomer.getStatus());
			accountDetail.setCreatedAt(registerdCustomer.getCreatedAt());
			accountDetail.setUpdatedAt(registerdCustomer.getUpdatedAt());

			customerService.addAccountDetail(accountDetail);
			
			CustomerResponseForCustomerRegister responseStructure = new CustomerResponseForCustomerRegister(new Date(),
					"Customer Regerstered successfully","200", registerdCustomer);
			return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
		}
		else
		{
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Customer Already Registered with same email", "409");
			return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
		}
	}
	
	@PostMapping("/loginCustomer")
	public ResponseEntity<Object>loginCustomer(@RequestBody customers customer)
	{
		validations.loginCustomer(customer);
		customers findCustomer = customerService.findCustomerByEmail(customer.getEmail());
		if(findCustomer != null)
		{
			if(findCustomer.getPassword().equals(customer.getPassword()))
			{
				customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
						"Login Succesfully..", "200");
				return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
			}
			else
			{
				customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
						"Invalid Credentials.", "400");
				return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
			}
		}
		else
		{
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Customer not found..", "409");
			return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
		}
	}
	@PostMapping("/fetchAccountDetails")
	public ResponseEntity<Object>fetchAccountDetails(@RequestBody AccountDetail accountDetail)
	{
		AccountDetail accountDetails = accountService.fetchAccountDetails(accountDetail.getAccountNumber());
		if(accountDetails!=null)
		{
			CustomerResponseForAccountDetail responseStructure = new CustomerResponseForAccountDetail(new Date(),
					"Account Detail Fetch successfully", "200", accountDetails);
			return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
		}
		else
		{
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Account Not Found..","409");
			return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
		}
	}
	@PostMapping("/UpdatePassword")
	public ResponseEntity<Object>UpdatePassword(@RequestBody UpdatePassword updatePassword)
	{
		validations.updatePassword(updatePassword);
		customers findCustomer = customerService.findCustomerByEmail(updatePassword.getEmail());
		if(findCustomer != null){
			if(updatePassword.getNewPassword().equals(updatePassword.getConfirmPassword())) {
					if(updatePassword.getNewPassword().equals(findCustomer.getPassword())){
						customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
								"Password sould not be same as old password..","409");
						return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
						}
						else{
						customerService.updatePassword(updatePassword.getConfirmPassword(),updatePassword.getEmail());
						customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
								"Password updated successfully","200");
						return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);

					}
			}
			else
			{
				customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
						"confirmed password not matched to new password","409");
				return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
			} 
		}
		else
		{
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Customer Not Found..","409");
			return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
		}
	}
	@PostMapping("/sendOtpOnEmail")
	public ResponseEntity<Object>sendOtpOnEmail(@RequestBody CustomOtpRequest customOtp)
	{
		customers findCustomer = customerService.findCustomerByEmail(customOtp.getEmailId());
		
		if(findCustomer !=null)
		{
			boolean sendEmail= mailService.sendMail(customOtp.getEmailId(), accountNumerGenerator.generateTransactionPin());
			if(sendEmail==true)
			{
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"OTP send on email..","200");
			return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
			}
			else
			{
				customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
						"Error Otp not send on email..","409");
				return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
			}
		}
		else
		{
			customerResponseForNoUser responseStructure = new customerResponseForNoUser(new Date(),
					"Email Id Not Found..","409");
			return new ResponseEntity<Object> (responseStructure, HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "ResetPassword",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public OperationStatus ResetPassword(@RequestBody PasswordResetRequestModel passwordResetRequestModel){
		OperationStatus returnValue= new OperationStatus();
		boolean resetRequest= customerService.requestPasswordReset(passwordResetRequestModel.getEmail());
		
		returnValue.setOperationName(RequestOperationName.REQUEST_PASSWORD_RESET.name());
		returnValue.setOperationResult(RequestOperationStatus.ERROR.name());
		if(resetRequest == true)
		{
			returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

		}
		return returnValue;
	}

	
}