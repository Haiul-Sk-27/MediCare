package com.example.MediCare.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pharmacyName;
    @Column(unique = true)
    private String licenseNumber;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pincode;
    private String pharmacyImage;
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
