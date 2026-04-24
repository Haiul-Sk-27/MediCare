package com.example.MediCare.model;

import com.example.MediCare.domain.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(nullable = false)
    private String fullName;
    @Column(unique = true,nullable = false,updatable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;
    @Column(nullable = false,updatable = false)
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime updatedAt;
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime lastLogin;
    private String image;
    private String address;

    @PrePersist
    public  void  onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public  void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
