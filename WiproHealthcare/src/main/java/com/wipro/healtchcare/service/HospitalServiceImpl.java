package com.wipro.healtchcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.healtchcare.dto.HospitalDto;
import com.wipro.healtchcare.entity.Hospital;
import com.wipro.healtchcare.repository.IHosptitalRepository;

@Service
public class HospitalServiceImpl implements IHospitalService {

    @Autowired
    private IHosptitalRepository hospitalRepo;

    private Hospital mapToHospital(HospitalDto hospital) {
    	
        Hospital h = new Hospital();
       // h.setHospitalId(hospital.getHospitalId());
        h.setHospitalName(hospital.getHospitalName());
        h.setLocation(hospital.getLocation());
        
        return h;
    }

    @Override
    public Hospital registerHospital(HospitalDto hospital) {
        return hospitalRepo.save(mapToHospital(hospital));
    }

    @Override
    public List<Hospital> viewAllHospitals() {
    	
        return hospitalRepo.findAll();
    }

    @Override
    public Hospital getHospitalById(int hospitalId) {
    	
        return hospitalRepo.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital Id not Found"));
    }

    @Override
    public List<Hospital> searchHospitalByLocation(String location) {
    	
        return hospitalRepo.findByLocation(location);
    }

    @Override
    public Hospital changeHospitalLocation(int hospitalId, String location) {
    	
        Hospital h = hospitalRepo.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital Id not Found"));

        h.setLocation(location);
        return hospitalRepo.save(h);
    }

    @Override
    public String removeHospital(int hospitalId) {
    	
        if (!hospitalRepo.existsById(hospitalId)) {
            throw new RuntimeException("Hospital Id not Found");
        }

        hospitalRepo.deleteById(hospitalId);
        return "Hospital removed successfully";
    }

    @Override
    public Integer getHospitalCount() {
    	
        return (int) hospitalRepo.count();
    }
}