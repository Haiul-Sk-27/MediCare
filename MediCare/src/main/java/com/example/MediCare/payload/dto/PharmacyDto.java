package com.example.MediCare.payload.dto;

import com.example.MediCare.model.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PharmacyDto {

    private Long id;
    private User user;
    private String pharmacyName;
    private String licenseNumber;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pincode;
    private String pharmacyImage;
    private LocalDateTime createdAt;
}
