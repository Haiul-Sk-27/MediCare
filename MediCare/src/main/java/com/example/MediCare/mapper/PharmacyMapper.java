package com.example.MediCare.mapper;

import com.example.MediCare.model.Pharmacy;
import com.example.MediCare.payload.dto.PharmacyDto;

public class PharmacyMapper {

    // ✅ Entity → DTO (Response)
    public static PharmacyDto toDTO(Pharmacy pharmacy){
        if (pharmacy == null) return null;

        PharmacyDto dto = new PharmacyDto();
        dto.setId(pharmacy.getId());
        dto.setPharmacyName(pharmacy.getPharmacyName());
        dto.setLicenseNumber(pharmacy.getLicenseNumber());
        dto.setPhone(pharmacy.getPhone());
        dto.setEmail(pharmacy.getEmail());
        dto.setAddress(pharmacy.getAddress());
        dto.setCity(pharmacy.getCity());
        dto.setState(pharmacy.getState());
        dto.setPincode(pharmacy.getPincode());
        dto.setPharmacyImage(pharmacy.getPharmacyImage());


        return dto;
    }

    public static Pharmacy toEntity(PharmacyDto dto){
        if(dto == null) return null;

        Pharmacy pharmacy = new Pharmacy();

        pharmacy.setPharmacyName(dto.getPharmacyName());
        pharmacy.setLicenseNumber(dto.getLicenseNumber());
        pharmacy.setPhone(dto.getPhone());
        pharmacy.setEmail(dto.getEmail());
        pharmacy.setAddress(dto.getAddress());
        pharmacy.setCity(dto.getCity());
        pharmacy.setState(dto.getState());
        pharmacy.setPincode(dto.getPincode());
        pharmacy.setPharmacyImage(dto.getPharmacyImage());

        return pharmacy;
    }
}