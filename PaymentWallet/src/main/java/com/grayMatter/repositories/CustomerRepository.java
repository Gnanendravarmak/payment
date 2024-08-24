package com.grayMatter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grayMatter.dto.LoginDto;
import com.grayMatter.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


	Optional<Customer> findByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);

	Optional<Customer> findByCustomerEmail(String customerEmail);

	Optional<Customer> findByCustomerMobileNumber(String mobileNumber);

}
