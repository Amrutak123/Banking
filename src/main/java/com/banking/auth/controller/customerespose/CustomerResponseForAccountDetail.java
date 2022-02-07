package com.banking.auth.controller.customerespose;

import java.util.Date;

import com.banking.auth.entities.AccountDetail;

public class CustomerResponseForAccountDetail {
	private  Date timestamp;
	private String message;
	private String status;
	private AccountDetail accountDetail;
	public CustomerResponseForAccountDetail() {
		super();
		
	}
	public CustomerResponseForAccountDetail(Date timestamp, String message, String status,
			AccountDetail accountDetail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.accountDetail = accountDetail;
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
	public AccountDetail getAccountDetail() {
		return accountDetail;
	}
	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}
	@Override
	public String toString() {
		return "CustomerResponseForAccountDetail [timestamp=" + timestamp + ", message=" + message + ", status="
				+ status + ", accountDetail=" + accountDetail + ", getTimestamp()=" + getTimestamp() + ", getMessage()="
				+ getMessage() + ", getStatus()=" + getStatus() + ", getAccountDetail()=" + getAccountDetail()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
