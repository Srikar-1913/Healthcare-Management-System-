package com.wipro.healtchcare.service;

import java.util.List;

import com.wipro.healtchcare.dto.PatientDto;
import com.wipro.healtchcare.entity.Patient;

public interface IPatientService {
	
	Patient addPatient(PatientDto patient);
	
	List<Patient> getAllPatients();
	
	Patient getPatientById(int patientId);
	
	Patient findPatientsByDisease(String disease);
	
	Patient getPatientsByGender(String gender);
	
	Patient getPatientsByAge(int PatientAge);
	
	String deletePatient(int patientId);
}
