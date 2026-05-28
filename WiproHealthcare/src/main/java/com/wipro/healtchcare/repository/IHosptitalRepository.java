package com.wipro.healtchcare.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.healtchcare.entity.Hospital;

public interface IHosptitalRepository extends JpaRepository<Hospital, Integer>{

	List<Hospital> findByLocation(String location);

}
