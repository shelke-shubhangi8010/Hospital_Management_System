package com.hospital.Hospital_Management_System.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital_Management_System.Entity.Doctor;

public interface DoctorRepository
        extends JpaRepository<Doctor, Long> {

}