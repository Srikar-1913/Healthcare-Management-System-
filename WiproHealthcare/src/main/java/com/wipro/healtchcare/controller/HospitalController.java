package com.wipro.healtchcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.healtchcare.dto.HospitalDto;
import com.wipro.healtchcare.entity.Hospital;
import com.wipro.healtchcare.service.IHospitalService;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private IHospitalService hospitalService;

    @PostMapping("/add")
    public Hospital registerHospital(@RequestBody HospitalDto hospital) {
        return hospitalService.registerHospital(hospital);
    }

    @GetMapping("/viewHospitals")
    public List<Hospital> viewAllHospitals() {
        return hospitalService.viewAllHospitals();
    }

    @GetMapping("/getHospitalById/{id}")
    public Hospital getHospitalById(@PathVariable int id) {
        return hospitalService.getHospitalById(id);
    }

    @GetMapping("/searchHospital/location/{location}")
    public List<Hospital> searchHospitalByLocation(@PathVariable String location) {
        return hospitalService.searchHospitalByLocation(location);
    }

    @PutMapping("/changeHospital/{id}/{location}")
    public Hospital changeHospitalLocation(@PathVariable int id, @PathVariable String location) {
        return hospitalService.changeHospitalLocation(id, location);
    }

    @DeleteMapping("/deleteHospital/{id}")
    public String removeHospital(@PathVariable int id) {
        return hospitalService.removeHospital(id);
    }

    @GetMapping("/hospital/count")
    public Integer getHospitalCount() {
        return hospitalService.getHospitalCount();
    }
}