package com.banking.auth.CustomerRequest;

public class CustomOtpRequest {
	private String accountNumber;
	public String emailId;
	private String transactionPin;
	public CustomOtpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomOtpRequest(String accountNumber, String emailId, String transactionPin) {
		super();
		this.accountNumber = accountNumber;
		this.emailId = emailId;
		this.transactionPin = transactionPin;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTransactionPin() {
		return transactionPin;
	}
	public void setTransactionPin(String transactionPin) {
		this.transactionPin = transactionPin;
	}
	@Override
	public String toString() {
		return "CustomOtpRequest [accountNumber=" + accountNumber + ", emailId=" + emailId + ", transactionPin="
				+ transactionPin + ", getAccountNumber()=" + getAccountNumber() + ", getEmailId()=" + getEmailId()
				+ ", getTransactionPin()=" + getTransactionPin() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}