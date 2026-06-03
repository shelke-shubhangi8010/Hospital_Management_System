package com.hospital.Hospital_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.LabReport;

public interface LabReportService {

    LabReport saveReport(LabReport report);

    List<LabReport> getAllReports();
}

