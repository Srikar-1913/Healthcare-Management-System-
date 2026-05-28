package com.wipro.healtchcare.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class PatientDto {
	
	private int patientId;
	
	@NotBlank(message = "Patient name cannot be empty")
	private String patientName;
	
	@Min(value = 1, message = "Age must be greater than 0")
	@Max(value = 120, message = "Age must be below 120")
	private int patientAge;
	
	@NotBlank(message = "Gender is required")
	@Pattern(
			regexp = "Male | Female | Other", message = "Gender must be Male, Female or Other")
	private String gender;
	
	@NotBlank(message = "Must have disease to admit in hospital")
	private String disease;
}
