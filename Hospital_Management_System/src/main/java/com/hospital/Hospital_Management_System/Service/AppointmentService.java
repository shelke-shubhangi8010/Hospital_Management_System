package com.hospital.Hospital_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.Appointment;
import com.hospital.Hospital_Management_System.Repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    // View All
    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }

    // Save + Update
    public Appointment saveAppointment(Appointment a) {
        return repo.save(a);
    }

    // Edit
    public Appointment getAppointmentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Delete
    public void deleteAppointment(Long id) {
        repo.deleteById(id);
    }
}
