package com.wipro.healtchcare.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.healtchcare.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer>{

	List<Patient> findByGender(String gender);

	List<Patient> findByDisease(String disease);

	List<Patient> findByPatientAge(int patientAge);

}
