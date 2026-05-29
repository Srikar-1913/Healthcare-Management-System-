package com.wipro.healtchcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.healtchcare.dto.DoctorDto;
import com.wipro.healtchcare.entity.Doctor;
import com.wipro.healtchcare.entity.Hospital;
import com.wipro.healtchcare.repository.IDoctorRepository;
import com.wipro.healtchcare.repository.IHosptitalRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepository doctorRepo;
    
    @Autowired
    private IHosptitalRepository hospitalRepo;

    private Doctor mapToDoctor(DoctorDto doctor) {
    	
        Doctor d = new Doctor();
        
        //d.setDoctorId(doctor.getDoctorId());
        d.setDoctorName(doctor.getDoctorName());
        d.setSpecialization(doctor.getSpecialization());
        d.setPhone(doctor.getPhone());
        
        Hospital h = hospitalRepo.findById(doctor.getHospitalId()).orElse(null);
        d.setHospital(h);
        
        return d;
    }

    @Override
    public Doctor addDoctor(DoctorDto doctor) {
    	
        return doctorRepo.save(mapToDoctor(doctor));
    }

    @Override
    public List<Doctor> getAllDoctors() {
    	
        return doctorRepo.findAll();
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
    	
        return doctorRepo.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor Id not Found"));
    }

    @Override
    public Doctor updateDoctorSpecialization(int doctorId, String specialization) {
    	
        Doctor d = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor Id not Found"));

        d.setSpecialization(specialization);
        return doctorRepo.save(d);
    }

    @Override
    public List<Doctor> findDoctorsBySpecialization(String specialization) {
    	
        return doctorRepo.findBySpecialization(specialization);
    }

    @Override
    public String deleteDoctor(int doctorId) {
    	
        if (!doctorRepo.existsById(doctorId)) {
            throw new RuntimeException("Doctor Id not Found");
        }
        doctorRepo.deleteById(doctorId);
        return "Doctor deleted successfully";
    }
}