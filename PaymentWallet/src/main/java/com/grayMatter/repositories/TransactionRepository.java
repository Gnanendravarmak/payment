package com.grayMatter.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	List<Transaction> findAllByWallet_WalletId(long walletId);

	List<Transaction> findAllByTransactionDate(LocalDate date);

	List<Transaction> findAllByTransactionType(String type);

	List<Transaction> findAllByTransactionDateBetween(LocalDate from, LocalDate to);

//	List<Transaction> findAllTransactionsByType(String type);


}
