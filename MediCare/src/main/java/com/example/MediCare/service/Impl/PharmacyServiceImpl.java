package com.example.MediCare.service.Impl;

import com.example.MediCare.domain.UserRole;
import com.example.MediCare.exceptions.UserExceptions;
import com.example.MediCare.mapper.PharmacyMapper;
import com.example.MediCare.model.Pharmacy;
import com.example.MediCare.model.User;
import com.example.MediCare.payload.dto.PharmacyDto;
import com.example.MediCare.repository.PharmacyRepository;
import com.example.MediCare.repository.UserRepository;
import com.example.MediCare.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {

    private final UserRepository userRepository;
    private final PharmacyRepository pharmacyRepository;

    @Override
    public PharmacyDto createPharmacy(PharmacyDto pharmacyDto) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String adminEmail = auth.getName();

        User admin = userRepository.findByEmail(adminEmail)
                .orElseThrow(() -> new UserExceptions("Admin not found"));

        if (admin.getRole() != UserRole.SUPER_ADMIN) {
            throw new UserExceptions("Access denied");
        }

        if(pharmacyRepository.existsByLicenseNumber(pharmacyDto.getLicenseNumber())){
            throw new Exception("Pharmacy alredy exists");
        }
        if (userRepository.existsByEmail(pharmacyDto.getEmail())) {
            throw new UserExceptions("Email already exists");
        }

        Pharmacy pharmacy = Pharmacy.builder()
                .pharmacyName(pharmacyDto.getPharmacyName())
                .licenseNumber(pharmacyDto.getLicenseNumber())
                .phone(pharmacyDto.getPhone())
                .email(pharmacyDto.getEmail())
                .address(pharmacyDto.getAddress())
                .city(pharmacyDto.getCity())
                .state(pharmacyDto.getState())
                .pincode(pharmacyDto.getPincode())
                .createdAt(LocalDateTime.now())
                .build();

        Pharmacy savedPharmacy = pharmacyRepository.save(pharmacy);

        return PharmacyMapper.toDTO(savedPharmacy);
    }
}
