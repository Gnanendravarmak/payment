package com.grayMatter.dto;



import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerRequestDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	
	@NotBlank(message = "Customer name is mandatory")
	@NotNull(message = "Customer name cannot be null")
	@NotEmpty(message = "Customer name cannot be empty")
	private String customerName;
	
	@NotBlank(message = "Customer email is mandatory")
    @Pattern(
//        regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
    		regexp = "[A-Za-z0-9\\._%+\\-]+@[A-Za-z0-9\\.\\-]+\\.[A-Za-z]{2,}",
        message = "Invalid email address format. Example: example@example.com"
    )
	private String customerEmail;

	@NotBlank(message = "Mobile number is mandatory")
	@NotNull(message = "Mobile number cannot be null")
	@NotEmpty(message = "Mobile number cannot be empty")
	@Column(unique = true)
	@Pattern(regexp = "[7-9][0-9]{9}", message = "The number must be 10 digits long and start with a digit between 7 to 9")
	private String customerMobileNumber;
	
	
	@NotBlank(message = "Password is mandatory")
	@NotNull(message = "Password cannot be null")
	@NotEmpty(message = "Password cannot be empty")
	@Pattern(regexp = "(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Z][a-zA-Z0-9!@#$%^&*]{7,}$", message = "Password must start with an uppercase letter and be at least 8 characters long, containing only letters, numbers, and special characters !@#$%^&*")
	private String customerPassword;

}
