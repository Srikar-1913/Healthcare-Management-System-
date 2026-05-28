package com.wipro.healtchcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HospitalDto {
	private int hospitalId;
	
	@NotBlank(message = "Hospital name cannot be empty")
	@Size(min = 3, max = 50, message = " Hospital name must be between 3 and 50 characters")
	private String hospitalName;
	
	@NotBlank(message = " Location cannot be empty")
	@Pattern(
			regexp = "^[A-Za-z ]+$", message = " Location must contain only alphabets")
	private String location;
}
