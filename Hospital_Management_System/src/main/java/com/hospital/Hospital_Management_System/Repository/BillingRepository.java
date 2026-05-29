package com.hospital.Hospital_Management_System.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital_Management_System.Entity.Billing;

public interface BillingRepository
        extends JpaRepository<Billing, Long> {

}
