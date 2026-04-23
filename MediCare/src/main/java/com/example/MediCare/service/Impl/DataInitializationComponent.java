package com.example.MediCare.service.Impl;

import com.example.MediCare.domain.UserRole;
import com.example.MediCare.model.User;
import com.example.MediCare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializationComponent implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run (String... args){
        initializedAdminUser();
    }
    private void initializedAdminUser() {

        String adminEmail = "superadmin@medicare.com";
        String adminPassword = "Super@123";

        if (userRepository.findByEmail(adminEmail).isEmpty()) {

            User user = User.builder()
                    .email(adminEmail)
                    .password(passwordEncoder.encode(adminPassword))
                    .fullName("Haiul Sk")
                    .role(UserRole.SUPER_ADMIN)
                    .build();

            userRepository.save(user);
        }
    }
}
