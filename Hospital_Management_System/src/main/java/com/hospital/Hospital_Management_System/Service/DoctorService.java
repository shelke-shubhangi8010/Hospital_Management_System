package com.hospital.Hospital_Management_System.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.Doctor;
import com.hospital.Hospital_Management_System.Repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

    public Doctor saveDoctor(Doctor d) {
        return repo.save(d);
    }

    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteDoctor(Long id) {
        repo.deleteById(id);
    }
    
    public long getDoctorCount() {
        return repo.count();
    }
}