package com.wipro.healtchcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.healtchcare.entity.Hospital;

public interface IHosptitalRepository extends JpaRepository<Hospital, Integer>{

}
