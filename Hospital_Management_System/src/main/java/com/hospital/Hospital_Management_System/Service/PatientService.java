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

    public Patient savePatient(Patient p) {
        return repo.save(p);
    }

    public List<Patient> getAllPatients() {
        return repo.findAll();
    }
    public Patient updatePatient(Long id, Patient p) {

        Patient patient = repo.findById(id).orElse(null);

        if(patient != null) {
            patient.setName(p.getName());
            patient.setAge(p.getAge());
            patient.setDisease(p.getDisease());
            patient.setPhone(p.getPhone());

            return repo.save(patient);
        }

        return null;
    }
    public void deletePatient(Long id) {
        repo.deleteById(id);
    }
    
    public Patient getPatientById(Long id) {

        return repo.findById(id).orElse(null);
    }
    
    public long getPatientCount() {
        return repo.count();
    }
}