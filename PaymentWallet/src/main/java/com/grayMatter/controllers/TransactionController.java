package com.grayMatter.controllers;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.dto.TransactionDto;
import com.grayMatter.services.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TransactionController {
	
	private final TransactionService transactionService;
	
	@PostMapping("/addTransction")
	public ResponseEntity<?> addTransaction(@RequestBody TransactionDto transactionDto) {
		return transactionService.addTransaction(transactionDto);
	}
	
	@GetMapping("/getAllTransactions")
	public ResponseEntity<?> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	
	@GetMapping("/getAllTransactionsById/{id}")
	public ResponseEntity<?> viewAllTransactionsByWallet(@PathVariable long id) {
		return transactionService.viewAllTransactionsByWallet(id);
	}
	
	@GetMapping("/getAllTransactionsByDate/{from}/{to}")
	public ResponseEntity<?> viewAllTransactionsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
		return transactionService.viewAllTransactionsByDate(from , to);
	}
	
	@GetMapping("/getAllTransactionsByType/{type}")
	public ResponseEntity<?> viewAllTransactionsByType(@PathVariable String type) {
		return transactionService.viewAllTransactionsByType(type);
	}
	

}
