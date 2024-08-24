package com.grayMatter.services;
import java.time.LocalDate;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.TransactionDao;
import com.grayMatter.dto.TransactionDto;
import com.grayMatter.entities.Transaction;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
	
	private final TransactionDao transactionDao;

	public ResponseEntity<?> addTransaction(TransactionDto transactionDto) {
		return transactionDao.addTransaction(transactionDto);
	}

	public ResponseEntity<?> getAllTransactions() {
		
		List<Transaction> allTransactions = transactionDao.getAllTransactions();
		
		if(allTransactions.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Transactions Found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(allTransactions);
		
	}

	public ResponseEntity<?> viewAllTransactionsByWallet(long id) {
		
		Optional<Transaction> transactionId = transactionDao.findByWalletId(id);
		
		if(!transactionId.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Transactions Found");
		}

		List<Transaction> transaction = transactionDao.findByAllTransactionsByWalletId(id);
		
		if(!transaction.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Transactions Found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(transaction);

	}

//	public ResponseEntity<?> viewAllTransactionsByDate(String date) {
//		
//		List<Transaction> transaction = transactionDao.findAllTransactionsByDate(date);
//		
//		if(transaction.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Transactions Found");
//		}
//		
//		return ResponseEntity.status(HttpStatus.OK).body(transaction);
//	}

	

	public ResponseEntity<?> viewAllTransactionsByDate(LocalDate from, LocalDate to) {

		List<Transaction> transaction = transactionDao.findAllTransactionsByTypeGreaterThanAndLessThan(from , to);

		if(transaction.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Transactions Found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(transaction);
		
	}

	public ResponseEntity<?> viewAllTransactionsByType(String type) {
		List<Transaction> transaction = transactionDao.findAllTransactionsByType(type);

		if(transaction.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Transactions Found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(transaction);
	}

}
