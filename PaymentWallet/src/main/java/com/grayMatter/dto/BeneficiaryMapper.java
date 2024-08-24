package com.grayMatter.dto;

import org.springframework.stereotype.Component;

import com.grayMatter.entities.BeneficiaryDetails;

@Component
public class BeneficiaryMapper {
	public BeneficiaryDetails mapToBeneficiary(BeneficiaryDto dto) {
		return new BeneficiaryDetails(dto.getBenficiaryId(),dto.getBeneficiaryName(),dto.getBeneficiaryAccNo()
				,dto.getBeneficiaryIFSCCode(),dto.getCust());
	}
	public BeneficiaryDto mapToBeneficiaryDto(BeneficiaryDetails b) {
		return new BeneficiaryDto(b.getBenficiaryId(),b.getBeneficiaryName(),b.getBeneficiaryAccNo()
				,b.getBeneficiaryIFSCCode(),b.getCust());
	}
}
