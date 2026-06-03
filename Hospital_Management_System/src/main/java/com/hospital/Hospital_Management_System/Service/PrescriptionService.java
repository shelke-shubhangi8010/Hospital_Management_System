package com.hospital.Hospital_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.Prescription;
import com.hospital.Hospital_Management_System.Repository.PrescriptionRepository;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository repo;

    public void savePrescription(
            Prescription p){
        repo.save(p);
    }

    public List<Prescription>
    getAllPrescription(){
        return repo.findAll();
    }
}
