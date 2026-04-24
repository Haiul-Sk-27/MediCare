package com.example.MediCare.service;

import com.example.MediCare.payload.dto.PharmacyDto;

public interface PharmacyService {

    PharmacyDto createPharmacy(PharmacyDto pharmacyDto) throws Exception;
}
