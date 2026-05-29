package com.hospital.Hospital_Management_System.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.Billing;
import com.hospital.Hospital_Management_System.Repository.BillingRepository;

@Service
public class BillingService {

    @Autowired
    private BillingRepository repo;

    public Billing saveBill(Billing b) {

        b.setTotalAmount(
                b.getTreatmentCost()
                + b.getMedicineCost());

        return repo.save(b);
    }

    public List<Billing> getAllBills() {
        return repo.findAll();
    }

    public Billing getBillById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteBill(Long id) {
        repo.deleteById(id);
    }
}