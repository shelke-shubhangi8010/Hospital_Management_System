package com.hospital.Hospital_Management_System.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital_Management_System.Entity.Appointment;
import com.hospital.Hospital_Management_System.Entity.Patient;

public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {

	static void saveAll(Patient patient) {
		// TODO Auto-generated method stub
		
	}

}
