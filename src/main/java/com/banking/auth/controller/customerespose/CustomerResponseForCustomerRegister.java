package com.banking.auth.controller.customerespose;

import java.util.Date;

import com.banking.auth.entities.customers;

public class CustomerResponseForCustomerRegister {
	 
	private  Date timestamp;
	private String message;
	private String status;
	private customers customer;
	public CustomerResponseForCustomerRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerResponseForCustomerRegister(Date timestamp, String message, String status, customers customer) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.customer = customer;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public customers getCustomer() {
		return customer;
	}
	public void setCustomer(customers customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerResponseForCustomerRegister [timestamp=" + timestamp + ", message=" + message + ", status="
				+ status + ", customer=" + customer + "]";
	}
	
}
