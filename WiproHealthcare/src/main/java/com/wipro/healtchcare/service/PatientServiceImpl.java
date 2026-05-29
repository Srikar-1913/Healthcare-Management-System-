package com.wipro.healtchcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.healtchcare.dto.PatientDto;
import com.wipro.healtchcare.entity.Patient;
import com.wipro.healtchcare.repository.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {
	
	@Autowired
	private IPatientRepository patientRepo;
	
	
	private Patient mapToPatient(PatientDto patient) {
		Patient p = new Patient();
		
		//p.setPatientId(patient.getPatientId());
		p.setPatientName(patient.getPatientName());
		p.setPatientAge(patient.getPatientAge());
		p.setGender(patient.getGender());
		p.setDisease(patient.getDisease());
		
		return p;
	}
	
	//private PatientDto mapToDto()

	@Override
	public Patient addPatient(PatientDto patient) {
		Patient p = mapToPatient(patient);
		
		
		return patientRepo.save(p);
	}

	@Override
	public List<Patient> getAllPatients() {
		
		return patientRepo.findAll();
	}

	@Override
	public Patient getPatientById(int patientId) {
		
		return patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient Id not Found"));
	}

	@Override
	public List<Patient> findPatientsByDisease(String disease) {
		
		return patientRepo.findByDisease(disease);
	}

	@Override
	public List<Patient> getPatientsByGender(String gender) {
		
		return patientRepo.findByGender(gender);
	}

	@Override
	public List<Patient> getPatientsByAge(int PatientAge) {
		
		return patientRepo.findByPatientAge(PatientAge);
	}

	@Override
	public String deletePatient(int patientId) {
		
		if (!patientRepo.existsById(patientId)) {
            throw new RuntimeException("Patient Id not Found");
        }
        
		patientRepo.deleteById(patientId);
        return "Patient deleted successfully";
	}

}
