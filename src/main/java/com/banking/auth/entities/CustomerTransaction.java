package com.banking.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String accountNumber;
	private String userAccountNumber;
	private long transferAmount;
	private String Status;
	private String branchName;
	private String ifsc;
	private String createdAt;
	private String updatedAt;
	public CustomerTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerTransaction(long id, String accountNumber, String userAccountNumber, long transferAmount,
			String status, String branchName, String ifsc, String createdAt, String updatedAt) {
		super();
		Id = id;
		this.accountNumber = accountNumber;
		this.userAccountNumber = userAccountNumber;
		this.transferAmount = transferAmount;
		this.Status = status;
		this.branchName = branchName;
		this.ifsc = ifsc;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
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
	public long getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(long transferAmount) {
		this.transferAmount = transferAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
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
		return "CustomerTransaction [Id=" + Id + ", accountNumber=" + accountNumber + ", userAccountNumber="
				+ userAccountNumber + ", transferAmount=" + transferAmount + ", Status=" + Status + ", branchName="
				+ branchName + ", ifsc=" + ifsc + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", getId()="
				+ getId() + ", getAccountNumber()=" + getAccountNumber() + ", getUserAccountNumber()="
				+ getUserAccountNumber() + ", getTransferAmount()=" + getTransferAmount() + ", getStatus()="
				+ getStatus() + ", getBranchName()=" + getBranchName() + ", getIfsc()=" + getIfsc()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}