package com.grayMatter.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BillType {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  private String name;

	  private String description;
	  
	  private double amount;
	  
	  
}


