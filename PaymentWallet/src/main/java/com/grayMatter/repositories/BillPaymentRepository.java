package com.grayMatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entities.BillPayment;

public interface BillPaymentRepository extends JpaRepository<BillPayment,Long> {

}
