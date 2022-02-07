package com.banking.auth.CustomerRequest;

public class CustomerRequestForMoneyTransfer {

	private String accountNumber;
	private String userAccountNumber;
	private long transferAmount;
	private String branchName;
	private String ifsc;
	private String transactionPin;
	private String createdAt;
	private String updatedAt;
	public CustomerRequestForMoneyTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerRequestForMoneyTransfer(String accountNumber, String userAccountNumber, long transferAmount,
			String branchName, String ifsc, String transactionPin, String createdAt, String updatedAt) {
		super();
		this.accountNumber = accountNumber;
		this.userAccountNumber = userAccountNumber;
		this.transferAmount =transferAmount;
		this.branchName = branchName;
		this.ifsc = ifsc;
		this.transactionPin = transactionPin;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserAccountNumber() {
		return userAccountNumber;
	}
	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public long gettransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(long transferAmount) {
		this.transferAmount = transferAmount;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getTransactionPin() {
		return transactionPin;
	}
	public void setTransactionPin(String transactionPin) {
		this.transactionPin = transactionPin;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "CustomerRequestForMoneyTransfer [accountNumber=" + accountNumber + ", userAccountNumber="
				+ userAccountNumber + ", amount=" + transferAmount + ", branchName=" + branchName + ", ifsc=" + ifsc
				+ ", transactionPin=" + transactionPin + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", getAccountNumber()=" + getAccountNumber() + ", getUserAccountNumber()=" + getUserAccountNumber()
				+ ", getAmount()=" + gettransferAmount() + ", getBranchName()=" + getBranchName() + ", getIfsc()=" + getIfsc()
				+ ", getTransactionPin()=" + getTransactionPin() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getUpdatedAt()=" + getUpdatedAt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}



