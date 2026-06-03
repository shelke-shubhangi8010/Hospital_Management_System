package com.hospital.Hospital_Management_System.Service;


import java.util.List;

import com.hospital.Hospital_Management_System.Entity.Schedule;

public interface ScheduleService {

    Schedule saveSchedule(Schedule schedule);

    List<Schedule> getAllSchedules();
}