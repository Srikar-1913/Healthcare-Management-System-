package com.wipro.healtchcare.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.healtchcare.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

	List<Doctor> findBySpecialization(String specialization);



}
