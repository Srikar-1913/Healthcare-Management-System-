package com.wipro.healtchcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.healtchcare.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer>{

}
