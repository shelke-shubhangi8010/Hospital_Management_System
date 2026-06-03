package com.hospital.Hospital_Management_System.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.Hospital_Management_System.Entity.Schedule;

public interface ScheduleRepository
extends JpaRepository<Schedule,Integer>{

}
