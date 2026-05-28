package com.wipro.healtchcare.dto;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;
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
public class DoctorDto {
	private int doctorId;
	
	@NotBlank(message = "Doctor name connot be empty")
	private String doctorName;
	
	@NotBlank(message = "Specialization is required")
	private String specialization;
	
	@NotBlank(message = "Phone number is required")
	@Pattern(
			regexp = "^[0-9]{10}$", message = "Phone number exactly contain 10 digits")
	private String phone;
	
}
