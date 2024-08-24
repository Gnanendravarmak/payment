package com.grayMatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entities.BeneficiaryDetails;
import java.util.List;


public interface BeneficiaryRepository extends JpaRepository<BeneficiaryDetails, Long>{
	
	public BeneficiaryDetails findByBeneficiaryAccNo(String beneficiaryAccNo);
}
