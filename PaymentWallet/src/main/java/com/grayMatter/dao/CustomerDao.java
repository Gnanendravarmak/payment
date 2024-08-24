package com.grayMatter.dao;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grayMatter.dto.LoginDto;
import com.grayMatter.entities.Customer;
import com.grayMatter.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CustomerDao {
	
	private final CustomerRepository customerRepository;

	public Customer createAccount(Customer customer) {
		
		return customerRepository.save(customer);
		
	}

	public Optional<Customer> getCustomerData(LoginDto loginDto) {
		
		return customerRepository.findByCustomerEmailAndCustomerPassword(loginDto.getCustomerEmail(),
				loginDto.getCustomerPassword());
		
	}

	public Optional<Customer> findByCustomerEmail(String customerEmail) {
		return customerRepository.findByCustomerEmail(customerEmail);
	}

	public Optional<Customer> findByMobileNumber(String mobileNumber) {
		return customerRepository.findByCustomerMobileNumber(mobileNumber);
	}

	public Optional<Customer> getByCustomerId(Long id) {
		return customerRepository.findById(id);
	}

}
