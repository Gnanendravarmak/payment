package com.grayMatter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BeneficiaryDetails {
	
	@Id
	private long benficiaryId;
	
	@NotBlank(message = "Name cannot be blank")
	@Size(min=3,message = "name cannot be less than 3 characters")
	@Size(max=100,message = "name cannot be more than 100 characters")
	private String beneficiaryName;
	
	@Pattern(regexp = "\\d{12}", message = "Account number should be exactly 12 digits")
	@NotBlank(message = "Account No. cannot be blank")
	private String beneficiaryAccNo;
	
	@Pattern(regexp = "[A-Z]{4}[A-Z0-9]{6}", message = "IFSC code should follow pattern")
	@NotBlank(message = "IFSC Code cannot be blank")
	private String beneficiaryIFSCCode;
	
	@ManyToOne
	@JoinColumn(name="customerId",referencedColumnName = "customerId")
	private Customer cust;
	
}
