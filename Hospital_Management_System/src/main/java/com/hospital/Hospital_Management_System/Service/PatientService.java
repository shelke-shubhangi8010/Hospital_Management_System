package com.hospital.Hospital_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.Patient;
import com.hospital.Hospital_Management_System.Repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    public Patient savePatient(Patient p) {
        return repo.save(p);
    }

    public void deletePatient(Long id) {
        repo.deleteById(id);
    }
}