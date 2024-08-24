package com.grayMatter.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.CustomerDao;
import com.grayMatter.dto.CustomerRequestDto;
import com.grayMatter.dto.LoginDto;
import com.grayMatter.entities.Customer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
	
	private final CustomerDao customerDao;

	public ResponseEntity<String> createAccount(CustomerRequestDto customerRequestDto) {
		
	    Optional<Customer> existingCustomerEmail = customerDao.findByCustomerEmail(customerRequestDto.getCustomerEmail());
	    
	    
	    if(existingCustomerEmail.isPresent()) {
	        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Customer with email address already exists, Please use a different email address");
	    }

		
		
	    
	    Optional<Customer> existingCustomer = customerDao.findByMobileNumber(customerRequestDto.getCustomerMobileNumber());
	    
	    if (existingCustomer.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Customer already registered with this mobile number");
	    }
	    
	    Customer customer = Customer.builder()
	            .customerId(customerRequestDto.getCustomerId())
	            .customerName(customerRequestDto.getCustomerName())
	            .customerEmail(customerRequestDto.getCustomerEmail())
	            .customerMobileNumber(customerRequestDto.getCustomerMobileNumber())
	            .customerPassword(customerRequestDto.getCustomerPassword())
	            .build();
	    
	    Customer createdCustomer = customerDao.createAccount(customer);
	    
	    if (createdCustomer == null) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create the account. Please try again");
	    }
	    
	    return ResponseEntity.status(HttpStatus.CREATED).body("Account successfully created");
	}




	public ResponseEntity<String> getCustomerData(LoginDto loginDto) {
	    
	    Optional<Customer> email = customerDao.findByCustomerEmail(loginDto.getCustomerEmail());
	    
	    if (!email.isPresent()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not found. Please create an account");
	    }
	    
	    Optional<Customer> data = customerDao.getCustomerData(loginDto);
	    
	    if (data.isPresent()) {
	        return ResponseEntity.status(HttpStatus.OK).body("Customer login successful");
	    }
	    
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed. The password provided does not match the email address");
	    
	}




	public Customer getByCustomerId(Long id) {
		Optional<Customer> customer = customerDao.getByCustomerId(id);
		if(customer.isPresent()) return customer.get();
		return null;
	}


}
