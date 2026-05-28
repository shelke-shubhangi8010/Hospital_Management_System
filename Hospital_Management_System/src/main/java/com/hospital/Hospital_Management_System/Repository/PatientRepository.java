package com.hospital.Hospital_Management_System.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital_Management_System.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
