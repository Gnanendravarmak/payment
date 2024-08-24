package com.grayMatter.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BillPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billId;
	@ManyToOne
//	@JoinColumn(name="wallet",referencedColumnName="wallet")
	private Wallet wallet;
	private String billType;
	private double amount;
	private LocalDate paymentDate;

}
