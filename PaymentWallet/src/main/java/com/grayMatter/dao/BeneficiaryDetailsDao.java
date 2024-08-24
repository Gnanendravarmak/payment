package com.grayMatter.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grayMatter.dto.BeneficiaryDto;
import com.grayMatter.dto.BeneficiaryMapper;
import com.grayMatter.entities.BeneficiaryDetails;
import com.grayMatter.exception.ResourceNotFoundException;
import com.grayMatter.repositories.BeneficiaryRepository;

@Repository
public class BeneficiaryDetailsDao {
	
	@Autowired
	BeneficiaryRepository repository;
	@Autowired
	BeneficiaryMapper bmap;
	
	public List<BeneficiaryDto>getAllBeneficiaries(){
		List<BeneficiaryDetails>blist = repository.findAll();
		return blist.stream().map((b)->bmap.mapToBeneficiaryDto(b)).collect(Collectors.toList());
	}
	public BeneficiaryDto addBeneficiary(BeneficiaryDto dto) throws ResourceNotFoundException {
		BeneficiaryDetails existingBeneficiary = repository.findByBeneficiaryAccNo(dto.getBeneficiaryAccNo());
		if(existingBeneficiary!=null) {
			throw new ResourceNotFoundException("duplicate accno found");
		}
		else {
			BeneficiaryDetails nb = bmap.mapToBeneficiary(dto);
			repository.save(nb);
			return dto;
		}
		
	}
	public void deleteBeneficiary(String accno) throws ResourceNotFoundException {
		BeneficiaryDetails existingBeneficiary = repository.findByBeneficiaryAccNo(accno);
		if(existingBeneficiary!=null) {
			repository.delete(existingBeneficiary);
		}
		else {
			throw new ResourceNotFoundException("accno not found");
		}
	}
	public BeneficiaryDto getBeneficiaryByAccno(String accno) throws ResourceNotFoundException {
		BeneficiaryDetails existingBeneficiary = repository.findByBeneficiaryAccNo(accno);
		if(existingBeneficiary!=null) {
			return bmap.mapToBeneficiaryDto(existingBeneficiary);
		}
		else {
			throw new ResourceNotFoundException("accno not found");
		}
	} 
	
	
	
}
