package com.wipro.healtchcare.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;

	private LocalDate appointmentDate;
	private String status;



	// Many appointments belong to one doctor
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	// Many appointments belong to one patient
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;


}
