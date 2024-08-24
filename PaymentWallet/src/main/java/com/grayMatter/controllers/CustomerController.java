package com.grayMatter.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.dto.CustomerRequestDto;
import com.grayMatter.dto.LoginDto;
import com.grayMatter.entities.Customer;
import com.grayMatter.services.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class CustomerController {
	
	private final CustomerService customerService;
	
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> createCustomerAccount(@RequestBody CustomerRequestDto customerRequestDto) {
		log.info("Data: ",customerRequestDto);
		return customerService.createAccount(customerRequestDto);
	}
	
	
	@PostMapping("/getCustomer")
	public ResponseEntity<?> customerLogin(@RequestBody LoginDto loginDto) {
		log.info("Login Data: ",loginDto.getCustomerEmail());
		System.out.println(loginDto.getCustomerEmail());
		return customerService.getCustomerData(loginDto);
	}
	
	
	@GetMapping("/getCustomerBy/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getByCustomerId(id);
	}
	
	
	

}
