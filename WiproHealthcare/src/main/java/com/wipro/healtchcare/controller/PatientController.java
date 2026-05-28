package com.wipro.healtchcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.healtchcare.dto.PatientDto;
import com.wipro.healtchcare.entity.Patient;
import com.wipro.healtchcare.service.IPatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	private IPatientService patientService;
	
	@PostMapping("/add")
    public Patient addPatient(@RequestBody PatientDto patient) {
		
        return patientService.addPatient(patient);
    }
	
	@GetMapping("getAllPatients")
    public List<Patient> getAllPatients() {
		
        return patientService.getAllPatients();
    }
	
	@GetMapping("getById/{id}")
    public Patient getPatientById(@PathVariable int id) {
		
        return patientService.getPatientById(id);
    }
	
	@GetMapping("/disease/{disease}")
    public List<Patient> findPatientByDisease(@PathVariable String disease) {
		
        return patientService.findPatientsByDisease(disease);
    }
	
	@GetMapping("/gender/{gender}")
    public List<Patient> getPatientsByGender(@PathVariable String gender) {
		
        return patientService.getPatientsByGender(gender);
    }
	
	@GetMapping("/age/{age}")
    public List<Patient> getpatientsByAge(@PathVariable int age) {
		
        return patientService.getPatientsByAge(age);
    }
	
	@DeleteMapping("/{id}")
    public String deletePatient(@PathVariable int id) {
		
        return patientService.deletePatient(id);
    }
}
