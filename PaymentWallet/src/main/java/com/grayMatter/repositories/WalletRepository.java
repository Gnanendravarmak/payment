package com.grayMatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer>{

}
