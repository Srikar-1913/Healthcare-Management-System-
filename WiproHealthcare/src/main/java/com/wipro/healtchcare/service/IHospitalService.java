package com.wipro.healtchcare.service;

import java.util.List;

import com.wipro.healtchcare.dto.HospitalDto;
import com.wipro.healtchcare.entity.Hospital;

public interface IHospitalService {
	
	Hospital registerHospital(HospitalDto hospital);
	
	List<Hospital> viewAllHospitals();
	
	Hospital getHospitalById(int hospitalId);
	
	List<Hospital> searchHospitalByLocation(String location);
	
	Hospital changeHospitalLocation(int hospitalId, String location);
	
	String removeHospital(int hospitalId);
}
