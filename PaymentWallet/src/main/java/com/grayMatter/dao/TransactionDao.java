package com.grayMatter.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grayMatter.dto.TransactionDto;
import com.grayMatter.entities.Transaction;
import com.grayMatter.repositories.TransactionRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TransactionDao {
	
	private final TransactionRepository transactionRepository;

	public ResponseEntity<?> addTransaction(TransactionDto transactionDto) {
		return null;
	}

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Optional<Transaction> findByWalletId(long id) {
		return transactionRepository.findById(id);
	}

	public List<Transaction> findByAllTransactionsByWalletId(long id) {
		return transactionRepository.findAllByWallet_WalletId(id);
	}

	public List<Transaction> findAllTransactionsByType(String type) {
		return transactionRepository.findAllByTransactionType(type);
	}



	public List<Transaction> findAllTransactionsByTypeGreaterThanAndLessThan(LocalDate from, LocalDate to) {
		return transactionRepository.findAllByTransactionDateBetween(from,to);
	}


}
