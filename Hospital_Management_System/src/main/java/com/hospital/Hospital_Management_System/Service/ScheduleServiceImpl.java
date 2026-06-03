package com.hospital.Hospital_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.Schedule;
import com.hospital.Hospital_Management_System.Repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl
implements ScheduleService {

    @Autowired
    ScheduleRepository repo;

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return repo.save(schedule);
    }
    
    @Override
    public List<Schedule> getAllSchedules() {
        return repo.findAll();
    }
}
