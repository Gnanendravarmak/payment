package com.grayMatter.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.dto.BeneficiaryDto;
import com.grayMatter.exception.ResourceNotFoundException;
import com.grayMatter.services.BeneficiaryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BeneficiaryController {
	@Autowired
	BeneficiaryService service;
	
	@GetMapping("/beneficiary")
	public ResponseEntity<?>getAllBeneficiaries() {
		Map<String,Object>map = new HashMap<String, Object>();
		List<BeneficiaryDto>blist = service.getAllBeneficiaries();
		if(!blist.isEmpty()) {
			map.put("message", "successfully fetched all data");
			map.put("data", blist);
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else {
			map.put("message", "failed to fetch data");
			map.put("data", null);
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/beneficiary")
	public ResponseEntity<?>addBeneficiary(@RequestBody BeneficiaryDto dto) throws ResourceNotFoundException {
		Map<String,Object>map = new HashMap<String, Object>();
		BeneficiaryDto newBeneficiary = service.addBeneficiary(dto);
		map.put("status", 200);
		map.put("data", newBeneficiary);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@DeleteMapping("/beneficiary/{accno}")
	public ResponseEntity<?>deleteBeneficiary(@PathVariable("accno")String accno) throws ResourceNotFoundException {
		Map<String,Object>map = new HashMap<String, Object>();
		service.deleteBeneficiary(accno);
		map.put("status", 200);
		map.put("data", null);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("/beneficiary/{accno}")
	public ResponseEntity<?>getBeneficiaryByAccno(@PathVariable("accno")String accno) throws ResourceNotFoundException {
		Map<String,Object>map = new HashMap<String, Object>();
		BeneficiaryDto existingBeneficiary = service.getBeneficiaryByAccno(accno);
		map.put("status", 200);
		map.put("data", existingBeneficiary);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	
}
