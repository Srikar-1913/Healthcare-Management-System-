package com.wipro.healtchcare.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private String specialization;
	private String phone;



	//  Many doctors belong to one hospital
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;

	// One doctor has many appointments
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;


	
}
