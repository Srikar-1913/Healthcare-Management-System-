package com.wipro.healtchcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.healtchcare.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

}
