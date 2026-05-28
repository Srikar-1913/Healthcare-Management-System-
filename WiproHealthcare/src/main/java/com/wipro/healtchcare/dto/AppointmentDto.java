package com.wipro.healtchcare.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class AppointmentDto {
	private int appointmentId;
	
	@NotNull(message = "Appointment date is required")
	@FutureOrPresent(message = "Appointment date cannot be in the past")
	private LocalDate appointmentDate;
	
	@NotBlank(message = "Status is required")
	@Pattern(
			regexp = "Pending | Confirmed | Cancelled | Completed", message = " Status must be Pending, Confirmed, Cancelled or Completed")
	private String status;
}
