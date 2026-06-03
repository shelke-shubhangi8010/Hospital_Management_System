package com.hospital.Hospital_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.LabReport;
import com.hospital.Hospital_Management_System.Repository.LabReportRepository;

@Service
public class LabReportServiceImpl
implements LabReportService {

    @Autowired
    LabReportRepository repo;

    @Override
    public LabReport saveReport(LabReport report) {
        return repo.save(report);
    }

    @Override
    public List<LabReport> getAllReports() {
        return repo.findAll();
    }

	
}
