package com.wipro.healtchcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.healtchcare.dto.DoctorDto;
import com.wipro.healtchcare.entity.Doctor;
import com.wipro.healtchcare.service.IDoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody DoctorDto doctor) {
    	
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors() {
    	
        return doctorService.getAllDoctors();
    }

    @GetMapping("/getDoctorById/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
    	
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/updateSpecialization/{id}/{specialization}")
    public Doctor updateSpecialization(@PathVariable int id, @PathVariable String specialization) {
    	
        return doctorService.updateDoctorSpecialization(id, specialization);
    }

    @GetMapping("/specialization/{specialization}")
    public List<Doctor> findBySpecialization(@PathVariable String specialization) {
    	
        return doctorService.findDoctorsBySpecialization(specialization);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable int id) {
    	
        return doctorService.deleteDoctor(id);
    }
}