package com.wipro.healtchcare.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.healtchcare.dto.AppointmentDto;
import com.wipro.healtchcare.entity.Appointment;
import com.wipro.healtchcare.repository.IAppointmentRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    private IAppointmentRepository appointmentRepo;

    private Appointment mapToAppointment(AppointmentDto appointment) {
    	
        Appointment a = new Appointment();
        a.setAppointmentId(appointment.getAppointmentId());
        a.setAppointmentDate(appointment.getAppointmentDate());
        a.setStatus(appointment.getStatus());
        
        return a;
    }

    @Override
    public Appointment bookAppointment(AppointmentDto appointment) {
    	
        return appointmentRepo.save(mapToAppointment(appointment));
    }

    @Override
    public List<Appointment> getAllAppointments() {
    	
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
    	
        return appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment Id not Found"));
    }

    @Override
    public List<Appointment> getAppointmentsByDate(LocalDate appointmentDate) {
    	
        return appointmentRepo.findByAppointmentDate(appointmentDate);
    }

    @Override
    public List<Appointment> getAppointmentsByStatus(String status) {
    	
        return appointmentRepo.findByStatus(status);
    }

    @Override
    public Appointment updateAppointmentStatus(int appointmentId, String status) {
    	
        Appointment a = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment Id not Found"));

        a.setStatus(status);
        return appointmentRepo.save(a);
    }

    @Override
    public String cancelAppointment(int appointmentId) {
    	
        if (!appointmentRepo.existsById(appointmentId)) {
            throw new RuntimeException("Appointment Id not Found");
        }
        appointmentRepo.deleteById(appointmentId);
        return "Appointment cancelled successfully";
    }
}