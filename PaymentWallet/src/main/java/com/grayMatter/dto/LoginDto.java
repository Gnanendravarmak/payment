package com.grayMatter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginDto {
	
	 @NotBlank(message = "Customer email is mandatory")
	 @Email(message = "Invalid email address format")
	 private String customerEmail;
	    
	 @NotBlank(message = "Customer password is mandatory")
	 @Size(min = 8, message = "Password must be at least 8 characters long")
	 private String customerPassword;

}
