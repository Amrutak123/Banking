package com.banking.auth.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customerId")
	private customers customerId;
	
	private String accountNumber;
	private String branchName;
	private String ifsc;
	private long accountBalance;
	private String status;
	private String createdAt;
	private String updatedAt;
	public AccountDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDetail(long id, customers customerId, String accoutNumber, String branchName, String ifsc,
			long accountBalance, String status, String createdAt, String updatedAt, String accountNumber) {
		super();
		Id = id;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.branchName = branchName;
		this.ifsc = ifsc;
		this.accountBalance = accountBalance;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public customers getCustomerId() {
		return customerId;
	}
	public void setCustomerId(customers customerId) {
		this.customerId = customerId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "AccountDetail [Id=" + Id + ", customerId=" + customerId + ", accountNumber=" + accountNumber
				+ ", branchName=" + branchName + ", ifsc=" + ifsc + ", accountBalance=" + accountBalance + ", status="
				+ status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

		
}

