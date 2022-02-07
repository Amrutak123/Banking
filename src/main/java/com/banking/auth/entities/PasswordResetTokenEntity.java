package com.banking.auth.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "passwordResetTokens")
public class PasswordResetTokenEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2362371652091601361L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String token;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private customers customer;

	public PasswordResetTokenEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordResetTokenEntity(long id, String token, customers customer) {
		super();
		this.id = id;
		this.token = token;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public customers getCustomer() {
		return customer;
	}

	public void setCustomer(customers customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "PasswordResetTokenEntity [id=" + id + ", token=" + token + ", customer=" + customer + "]";
	}
	
	
	
}
