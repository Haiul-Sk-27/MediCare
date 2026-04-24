package com.example.MediCare.controller;

import com.example.MediCare.payload.dto.PharmacyDto;
import com.example.MediCare.payload.response.ApiResponse;
import com.example.MediCare.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/super-admin")
@RequiredArgsConstructor
public class PharmacyController {

    private final PharmacyService pharmacyService;

    @PostMapping("/pharmacies")
    public ResponseEntity<ApiResponse<PharmacyDto>> createPharmacy(@RequestBody PharmacyDto pharmacyDto) throws Exception {
        PharmacyDto createPharmacy = pharmacyService.createPharmacy(pharmacyDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Pharmacy created successfully",createPharmacy));
    }
}
