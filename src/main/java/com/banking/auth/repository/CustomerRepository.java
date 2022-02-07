package com.banking.auth.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.auth.entities.customers;

@Repository
public interface CustomerRepository extends JpaRepository<customers, Long>{
	@Query("SELECT c FROM customers c WHERE c.email=?1")
	customers findCustomerByEmail(String email);
	
	@Query("SELECT c FROM customers c WHERE c.customerId=?1")
	customers findById(long customerId);
	

	@Transactional
	@Modifying
	@Query("UPDATE customers c SET c.firstName= ?1, c.middleName=?2,c.lastName=?3,c.address=?4 WHERE c.customerId=?5")
	int updateCustomer(String firstName, String middleName, String lastName, String address, long customerId);

	@Transactional
	@Modifying
	@Query("UPDATE customers c SET c.password= ?1 WHERE c.email=?2")
	int updatePassword(String confirmPassword, String email);
	
}

