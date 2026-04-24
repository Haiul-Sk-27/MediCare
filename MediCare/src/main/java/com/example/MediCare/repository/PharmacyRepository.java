package com.example.MediCare.repository;

import com.example.MediCare.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy,Long> {
    boolean existsByLicenseNumber (String licenseNumber);
}
