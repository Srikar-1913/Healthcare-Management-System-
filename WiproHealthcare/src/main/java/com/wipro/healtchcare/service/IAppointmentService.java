package com.wipro.healtchcare.service;

import java.time.LocalDate;

import java.util.List;

import com.wipro.healtchcare.dto.AppointmentDto;
import com.wipro.healtchcare.entity.Appointment;

public interface IAppointmentService {
	
	Appointment bookAppointment(AppointmentDto appoinment);
	
	List<Appointment> getAllAppointments();
	
	Appointment getAppointmentById(int appointmentId);
	
	List<Appointment> getAppointmentsByDate(LocalDate appointmentDate);
	
	List<Appointment> getAppointmentsByStatus(String status);
	
	Appointment updateAppointmentStatus(int appointmentId, String status);
	
	String cancelAppointment(int appointmentId);
}
