package com.grayMatter.dto;

import org.springframework.stereotype.Component;

import com.grayMatter.entities.BillPayment;

@Component
public class BillPaymentMapper {
	public BillPayment maptoBillPayment(BillPaymentDto dto) {
		return new BillPayment(dto.getBillId(),dto.getWallet(),dto.getBillType(),dto.getAmount()
				,dto.getPaymentDate());
	}
	public BillPaymentDto maptoBillPaymentDto(BillPayment b) {
		return new BillPaymentDto(b.getBillId(),b.getWallet(),b.getBillType(),b.getAmount()
				,b.getPaymentDate());
	}
}
