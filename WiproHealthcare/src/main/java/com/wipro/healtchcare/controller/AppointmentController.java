package com.wipro.healtchcare.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.healtchcare.dto.AppointmentDto;
import com.wipro.healtchcare.entity.Appointment;
import com.wipro.healtchcare.service.IAppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping("/add")
    public Appointment bookAppointment(@RequestBody AppointmentDto appointment) {
    	
        return appointmentService.bookAppointment(appointment);
    }

    @GetMapping("/getAllAppointments")
    public List<Appointment> getAllAppointments() {
    	
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/getAppointmentById/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
    	
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/getAppointment/date/{date}")
    public List<Appointment> getAppointmentByDate(@PathVariable String date) {
    	
        return appointmentService.getAppointmentsByDate(LocalDate.parse(date));
    }

    @GetMapping("/getAppointment/status/{status}")
    public List<Appointment> getAppointmentByStatus(@PathVariable String status) {
    	
        return appointmentService.getAppointmentsByStatus(status);
    }

    @PutMapping("/updateAppointmentStatus/{id}/{status}")
    public Appointment updateAppointmentStatus(@PathVariable int id, @PathVariable String status) {
    	
        return appointmentService.updateAppointmentStatus(id, status);
    }

    @DeleteMapping("/cancelAppointment/{id}")
    public String cancelAppointment(@PathVariable int id) {
    	
        return appointmentService.cancelAppointment(id);
    }
}