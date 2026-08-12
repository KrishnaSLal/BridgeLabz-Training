package com.contacts.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactPatchDTO {

	@Size(min = 2, max = 50, message = "First name must be between 2 to 50 characters")
	private String firstName;
	
	@Size(min = 1, max = 50, message = "Last name must be between 1 to 50 characters")
	private String lastName;
	
    @Email(message = "Enter a valid email address")
    private String email;
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exact 10 digits")
    private String phone;
    
    @Pattern (regexp = "[0-9]{10}$", message = "Alternate phone number must contain exact 10 digits")
    private String alternatePhone;
}
