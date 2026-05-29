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

    public Appointment saveAppointment(
            Appointment a) {

        return repo.save(a);
    }

    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }

    public Appointment getAppointmentById(
            Long id) {

        return repo.findById(id).orElse(null);
    }

    public void deleteAppointment(
            Long id) {

        repo.deleteById(id);
    }
    
    public long getAppointmentCount() {
        return repo.count();
    }
}
