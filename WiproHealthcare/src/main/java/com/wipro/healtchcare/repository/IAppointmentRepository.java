package com.wipro.healtchcare.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.healtchcare.entity.Appointment;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{

	List<Appointment> findByAppointmentDate(LocalDate appointmentDate);

	List<Appointment> findByStatus(String status);

}
