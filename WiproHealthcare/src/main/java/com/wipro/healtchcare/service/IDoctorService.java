package com.wipro.healtchcare.service;

import java.util.List;

import com.wipro.healtchcare.dto.DoctorDto;
import com.wipro.healtchcare.entity.Doctor;

public interface IDoctorService {
	
	Doctor addDoctor(DoctorDto doctor);
	
	List<Doctor> getAllDoctors();
	
	Doctor getDoctorById(int doctorId);
	
	Doctor updateDoctorSpecialization(int doctorId, String specialization);
	
	List<Doctor> findDoctorsBySpecialization(String specialization);
	
	String deleteDoctor(int doctorId);

}
