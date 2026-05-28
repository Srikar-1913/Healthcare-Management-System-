package com.wipro.healtchcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.healtchcare.entity.Appointment;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{

}
