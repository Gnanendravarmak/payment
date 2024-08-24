package com.grayMatter.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.BeneficiaryDetailsDao;
import com.grayMatter.dto.BeneficiaryDto;
import com.grayMatter.entities.BeneficiaryDetails;
import com.grayMatter.exception.ResourceNotFoundException;

@Service
public class BeneficiaryService {
	@Autowired
	BeneficiaryDetailsDao dao;
	
	public List<BeneficiaryDto>getAllBeneficiaries(){
		return dao.getAllBeneficiaries();
	}
	public BeneficiaryDto addBeneficiary(BeneficiaryDto dto) throws ResourceNotFoundException {
		return dao.addBeneficiary(dto);	
	}
	public void deleteBeneficiary(String accno) throws ResourceNotFoundException {
		dao.deleteBeneficiary(accno);
		return ;	
	}
	public BeneficiaryDto getBeneficiaryByAccno(String accno) throws ResourceNotFoundException {
		return dao.getBeneficiaryByAccno(accno);
	} 
}
